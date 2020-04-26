import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;


/**
 * Created by anton on 25.04.2020.
 */
public class Main extends Application{

    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(root, 600,700);
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        root.setCenter(pane);
        HBox box1 = new HBox();
        HBox box2 = new HBox();
        HBox box3 = new HBox();
        HBox box4 = new HBox();
        HBox box5 = new HBox();
        HBox box6 = new HBox();
        HBox box7 = new HBox();
        HBox box8 = new HBox();
        HBox box9 = new HBox();
        HBox box10 = new HBox();
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();

        primaryStage.setScene(scene);
        primaryStage.show();

        TextField tf1 = new TextField();
        tf1.setPromptText("Region");
       // GridPane.setConstraints(tf1, 2, 1/*, 20,1, HPos.RIGHT, VPos.CENTER*/);
        root.getChildren().add(tf1);

        TextField tf2 = new TextField();
        tf2.setPromptText("Sity");
        //GridPane.setConstraints(tf2, 2, 2);
        root.getChildren().add(tf2);

        TextField tf3 = new TextField();
        tf3.setPromptText("District");
        //GridPane.setConstraints(tf3, 2, 3);
        root.getChildren().add(tf3);

        TextField tf4 = new TextField();
        tf4.setPromptText("Strit");
        //GridPane.setConstraints(tf4, 2, 4);
        root.getChildren().add(tf4);

        TextField tf5 = new TextField();
        tf5.setPromptText("House number");
        //GridPane.setConstraints(tf5, 2, 5);
        root.getChildren().add(tf5);

        TextField tf6 = new TextField();
        tf6.setPromptText("Floor");
        //GridPane.setConstraints(tf6, 2, 6);
        root.getChildren().add(tf6);

        TextField tf7 = new TextField();
        tf7.setPromptText("Rooms count");
        //GridPane.setConstraints(tf7, 2, 7);
        root.getChildren().add(tf7);

        Label label1 = new Label("Input region name");
        //GridPane.setConstraints(label1, 0, 1);
        root.getChildren().add(label1);

        Label label2 = new Label("Input sity name");
        GridPane.setConstraints(label2, 0, 2);
        root.getChildren().add(label2);

        Label label3 = new Label("Input district name");
        //GridPane.setConstraints(label3, 0, 3);
        root.getChildren().add(label3);

        Label label4 = new Label("Input street name");
        //GridPane.setConstraints(label4, 0, 4);
        root.getChildren().add(label4);

        Label label5 = new Label("Input hous number");
        //GridPane.setConstraints(label5, 0, 5);
        root.getChildren().add(label5);

        Label label6 = new Label("Input floor number");
        //GridPane.setConstraints(label6, 0, 6);
        root.getChildren().add(label6);

        Label label7 = new Label("Enter rooms count");
        //GridPane.setConstraints(label7, 0, 7);
        root.getChildren().add(label7);

        Label labelTop = new Label("Appartments");
        //GridPane.setConstraints(labelTop, 1, 0);
        root.getChildren().add(labelTop);

        Label result = new Label("");
        //GridPane.setConstraints(result, 0, 11/*,0,0,HPos.RIGHT,VPos.CENTER*/);
        root.getChildren().add(result);

        Button search = new Button("Search");
        GridPane.setConstraints(search, 2, 9);
        root.getChildren().add(search);
        search.setOnAction(event->{
            if(!tf1.getText().isEmpty() || !tf2.getText().isEmpty() || !tf3.getText().isEmpty() ||
                    !tf4.getText().isEmpty() || !tf5.getText().isEmpty() || !tf6.getText().isEmpty() ||
                    !tf7.getText().isEmpty()){
                HashMap<String, String> appart = new HashMap<>();
                appart.put("marker", "search");
                if(!tf1.getText().isEmpty()){appart.put("region", tf1.getText().toLowerCase());}
                if(!tf2.getText().isEmpty()){appart.put("sity", tf2.getText().toLowerCase());}
                if(!tf3.getText().isEmpty()){appart.put("district", tf3.getText().toLowerCase());}
                if(!tf4.getText().isEmpty()){appart.put("street", tf4.getText().toLowerCase());}
                if(!tf5.getText().isEmpty()){appart.put("numberHous", tf5.getText());}
                if(!tf6.getText().isEmpty()){appart.put("floor", tf6.getText());}
                if(!tf7.getText().isEmpty()){appart.put("numberAppartment", tf7.getText());}
                Connector connector = new Connector();


                result.setText(connector.result(appart));
            }
        });
        Button add = new Button("Add");
        GridPane.setConstraints(add, 1, 9);
        root.getChildren().add(add);
        add.setOnAction(event->{
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !tf3.getText().isEmpty() &&
                    !tf4.getText().isEmpty() && !tf5.getText().isEmpty() && !tf6.getText().isEmpty() &&
                    !tf7.getText().isEmpty()){
                HashMap<String, String> appart = new HashMap<>();
                appart.put("marker", "app");
                if(!tf1.getText().isEmpty()){appart.put("region", tf1.getText().toLowerCase());}
                if(!tf2.getText().isEmpty()){appart.put("sity", tf2.getText().toLowerCase());}
                if(!tf3.getText().isEmpty()){appart.put("district", tf3.getText().toLowerCase());}
                if(!tf4.getText().isEmpty()){appart.put("street", tf4.getText().toLowerCase());}
                if(!tf5.getText().isEmpty()){appart.put("numberHous", tf5.getText());}
                if(!tf6.getText().isEmpty()){appart.put("floor", tf6.getText());}
                if(!tf7.getText().isEmpty()){appart.put("numberAppartment", tf7.getText());}
                Connector connector = new Connector();
                connector.result(appart);

                result.setText("Done!");
            }else {
                result.setText("You must input an information in all fields.");
            }
        });

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 0, 9);
        root.getChildren().add(clear);
        clear.setOnAction(event -> {
            tf1.clear();
            tf2.clear();
            tf3.clear();
            tf4.clear();
            tf5.clear();
            tf6.clear();
            tf7.clear();
            result.setText("");
        });

        box1.getChildren().addAll(tf1, label1);
        box2.getChildren().addAll(tf2, label2);
        box3.getChildren().addAll(tf3, label3);
        box4.getChildren().addAll(tf4, label4);
        box5.getChildren().addAll(tf5, label5);
        box6.getChildren().addAll(tf6, label6);
        box7.getChildren().addAll(tf7, label7);
        vBox1.getChildren().addAll(box1, box2, box3, box4, box5, box6, box7);
        box8.getChildren().addAll(labelTop);
        box9.getChildren().addAll(result);
        box10.getChildren().addAll(clear, add, search);
        vBox2.getChildren().addAll(box10, box9);
        root.setCenter(vBox1);
        root.setTop(labelTop);
        root.setAlignment(labelTop, Pos.TOP_CENTER);
        root.setBottom(vBox2);
    }

    public static void main(String[] args){
    launch(args);
    }
}
