package AdapterPattern;

public class MediaAdapterDemo {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "beyond the horizon");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away");
		audioPlayer.play("avi", "mind me.avi");

	}

}
