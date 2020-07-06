package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.editor.Editor;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Editor editor = new Editor();
        editor.init(primaryStage);
    }
}