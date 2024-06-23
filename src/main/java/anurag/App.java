package anurag;

import java.util.ArrayList;
import java.util.List;

import anurag.AutoComplete.AutoCompleteModule;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    private AutoCompleteModule ac = new AutoCompleteModule();

    private String getCurrentWord(TextArea textArea) {
        String text = textArea.getText();
        if(text.length()==0)return text;
        int caretPosition = textArea.getCaretPosition();
        int start = caretPosition;
        while (start > 0 && text.charAt(start - 1) != ' ') {
            start--;
        }
        System.out.println(text.substring(start, caretPosition));
        return text.substring(start, caretPosition);
    }

    @Override
    public void start(Stage stage) {

        ListView<String> listView = new ListView<>();

        TextArea textArea = new TextArea();
        textArea.setPromptText("Edit here...");

        textArea.setOnKeyPressed(event -> {
            String keyCode = event.getCode().toString();
            if(keyCode.equals("TAB")){
                event.consume();
                System.out.println("TAB");
            }
        });

        textArea.setOnKeyReleased(event -> {
            String keyCode = event.getCode().toString();
            listView.getItems().clear();
            if(!keyCode.equals("SPACE")) {
                String prefix = getCurrentWord(textArea);
                List<String> result = ac.search(prefix);
                System.out.println(result.size());
                listView.getItems().setAll(result);
            }
        });

        double minWidthLeft = Math.floor(0.7*640);
        double minWidthRight = Math.floor(0.3*640);

        textArea.setMinWidth(minWidthLeft);
        listView.setMinWidth(minWidthRight);

        SplitPane splitPane = new SplitPane();

        splitPane.getItems().addAll(textArea, listView);
        splitPane.setDividerPositions(0.7);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(splitPane);

        Scene scene = new Scene(borderPane, 640 , 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
