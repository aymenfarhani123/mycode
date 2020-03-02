package com.example.demobatchlistener;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class WriterListener implements ItemWriteListener<User> {

    private String INSERT_QUERY = "insert into user_stats(firstName,lastName,city,id) values (?,?,?,?)";
    private DataSource dataSource;


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void beforeWrite(List<? extends User> list) {
        System.out.println("Going to write following items: "+ list.toString());
    }

    @Override
    public void afterWrite(List<? extends User> list) {
        System.out.println("Feeding the stats table");
        int result=0;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        for(User user:list){
            Object[] params = {user.getFirstName(),user.getLastName(),user.getCity(),user.getId()};
            result+=jdbcTemplate.update(INSERT_QUERY,params);
        }
        System.out.println("Number of rows inserted: "+ result);
    }


    @Override
    public void onWriteError(Exception e, List<? extends User> list) {
        System.out.println("Error occurred when writing items!");
    }
}
