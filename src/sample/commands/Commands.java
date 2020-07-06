package sample.commands;

import sample.editor.Editor;

public class Commands {
    public Editor editor;
    private String backup;

    public Commands(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public void runCommand(CommandHistory commandHistory){
        backup();
        editor.textField.setText("Player is running");
        commandHistory.push(this);
    }

    public void walkCommand(CommandHistory commandHistory){
        backup();
        editor.textField.setText("Player is walking");
        commandHistory.push(this);
    }

    public void sneakCommand(CommandHistory commandHistory){
        backup();
        editor.textField.setText("Player is sneaking");
        commandHistory.push(this);
    }
}
