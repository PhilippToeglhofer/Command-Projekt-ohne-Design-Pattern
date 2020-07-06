package sample.editor;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.commands.*;

public class Editor {
    public TextField textField;
    private CommandHistory commandHistory = new CommandHistory();
    private Commands commands;

    public void init(Stage primaryStage) {
        Editor editor = this;
        textField = new TextField();
        //commands = new Commands(editor);
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        Button runButton1 = new Button("Run");
        Button walkButton1 = new Button("Walk");
        Button sneakButton1 = new Button("Sneak");
        Button undoButton1 = new Button("Undo");

        runButton1.setOnMouseClicked(event -> executeRunCommand(editor));
        walkButton1.setOnMouseClicked(event -> executeWalkCommand(editor));
        sneakButton1.setOnMouseClicked(event -> executeSneakCommand(editor));
        undoButton1.setOnMouseClicked(event -> undo());

        root.getChildren().addAll(runButton1, walkButton1, sneakButton1, undoButton1, textField);

        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void executeRunCommand(Editor editor) {
        commands = new Commands(editor);
        commands.runCommand(commandHistory);
    }

    private void executeWalkCommand(Editor editor) {
        commands = new Commands(editor);
        commands.walkCommand(commandHistory);
    }

    private void executeSneakCommand(Editor editor) {
        commands = new Commands(editor);
        commands.sneakCommand(commandHistory);
    }

    private void undo() {
        if (commandHistory.isEmpty()){
            return;
        }

        Commands command = commandHistory.pop();
        if (command != null) {
            command.undo();
        }
    }


}