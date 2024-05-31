package com.example.navalbattle.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {
    private GameStage gameStage;

    /**
     *
     * @throws IOException
     */
    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/navalbattle/game-naval-battle.fxml"));
        Parent parent =loader.load();
        setTitle("Naval Battle");
        Scene scene = new Scene(parent);
        setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/com/example/navalbattle/NavalBattleStyles.css").toExternalForm());
        setResizable(false);
        show();
    }
    private static class GameStageHolder{
        private static GameStage INSTANCE;
    }
    public static GameStage getInstance() throws IOException {
        return GameStageHolder.INSTANCE=new GameStage();
    }
    public static void deleteInstance(){
        GameStage.GameStageHolder.INSTANCE.close();
        GameStage.GameStageHolder.INSTANCE=null;
    }

}