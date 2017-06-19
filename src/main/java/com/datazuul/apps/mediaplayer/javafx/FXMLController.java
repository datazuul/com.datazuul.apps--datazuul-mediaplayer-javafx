package com.datazuul.apps.mediaplayer.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javax.swing.DefaultListModel;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class FXMLController implements Initializable {

  DefaultListModel<String> songList = new DefaultListModel<>();
  ScheduledExecutorService timersExec = Executors.newSingleThreadScheduledExecutor();
  ScheduledExecutorService titleExec = Executors.newSingleThreadScheduledExecutor();
  float currentAudioDurationSec = 0;

  //AudioPlayer
  AudioPlayer player = AudioPlayer.getInstance();

  @FXML
  BorderPane equalizerPane;
  
  @FXML
  BorderPane playlistPane;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    player.addSong("/home/ralf/Music/song60a.mp3");
    playlistPane.managedProperty().bind(playlistPane.visibleProperty());
  }

  @FXML
  private void btnPauseClicked(ActionEvent event) {
//    if (songList.size() == 0) {
//      return;
//    }
    try {
      player.pause();
      playlistPane.setVisible(false);
    } catch (BasicPlayerException e1) {
      e1.printStackTrace();
    }
  }

  @FXML
  private void btnPlayClicked(ActionEvent event) {
//    if (songList.size() == 0) {
//      return;
//    }
    try {
      player.play();
      playlistPane.setVisible(true);
      equalizerPane.setVisible(true);
    } catch (BasicPlayerException e1) {
      e1.printStackTrace();
    }
  }

  @FXML
  private void btnStopClicked(ActionEvent event) {
//    if (songList.size() == 0) {
//      return;
//    }
    try {
      player.stop();
      equalizerPane.setVisible(false);
    } catch (BasicPlayerException e1) {
      e1.printStackTrace();
    }
  }

  private void togglePlay() throws BasicPlayerException {
//    if (songList.size() == 0) {
//      return;
//    }
//    if (!player.isPaused()) {
//      player.pause();
//      //btnPlay.setText(">");
//      btnPlay.setIcon(playIcon);
//    } else {
//      player.play();
//    }
  }
}
