/**
 * Sample Skeleton for 'Form.fxml' Controller Class
 */

package ctrl;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import model.db.FarmDBOperator;

public class FormController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label_Title"
    private Label label_Title; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_name"
    private TextField textfield_name; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_groupname"
    private TextField textfield_groupname; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_type"
    private TextField textfield_type; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_updatedatetime"
    private TextField textfield_updatedatetime; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_plantdate"
    private TextField textfield_plantdate; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_reapdate"
    private TextField textfield_reapdate; // Value injected by FXMLLoader

    @FXML // fx:id="combobox_reapcount"
    private ComboBox<?> combobox_reapcount; // Value injected by FXMLLoader

    @FXML // fx:id="textarea_notes"
    private TextArea textarea_notes; // Value injected by FXMLLoader

    @FXML // fx:id="label_datetime"
    private Label label_datetime; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert label_Title != null : "fx:id=\"label_Title\" was not injected: check your FXML file 'Form.fxml'.";
        assert textfield_name != null : "fx:id=\"textfield_name\" was not injected: check your FXML file 'Form.fxml'.";
        assert textfield_groupname != null : "fx:id=\"textfield_groupname\" was not injected: check your FXML file 'Form.fxml'.";
        assert textfield_type != null : "fx:id=\"textfield_type\" was not injected: check your FXML file 'Form.fxml'.";
        assert textfield_updatedatetime != null : "fx:id=\"textfield_updatedatetime\" was not injected: check your FXML file 'Form.fxml'.";
        assert textfield_plantdate != null : "fx:id=\"textfield_plantdate\" was not injected: check your FXML file 'Form.fxml'.";
        assert textfield_reapdate != null : "fx:id=\"textfield_reapdate\" was not injected: check your FXML file 'Form.fxml'.";
        assert combobox_reapcount != null : "fx:id=\"combobox_reapcount\" was not injected: check your FXML file 'Form.fxml'.";
        assert textarea_notes != null : "fx:id=\"textarea_notes\" was not injected: check your FXML file 'Form.fxml'.";
        assert label_datetime != null : "fx:id=\"label_datetime\" was not injected: check your FXML file 'Form.fxml'.";

        // リアルタイム日時を取得しセットし続ける
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            String dt = sdf.format(Calendar.getInstance().getTime());
            int second = LocalDateTime.now().getSecond();
            int minute = LocalDateTime.now().getMinute();
            int hour = LocalDateTime.now().getHour();
            label_datetime.setText(dt + " " + hour + ":" + (minute) + ":" + second);
        }),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        // 農場情報を表示
        FarmDBOperator farm = new FarmDBOperator();
        farm.selectId("A0001");
        textfield_name.setText(farm.getName().get(0));
        textfield_groupname.setText(farm.getGroupname().get(0));
        textfield_type.setText(farm.getType().get(0));


    }
}
