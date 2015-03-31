package jsfstudy;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;

@ManagedBean
@SessionScoped
@Slf4j
public class TransientViewWithSessionScopeBeanPage {
    @NotBlank(message = "何かを入力してください。")
    @Getter @Setter private String something;
    @Getter private String result;

    @Getter private boolean somethingDone = false;
    
    public TransientViewWithSessionScopeBeanPage() {
        logger.info("TransientViewWithSessionScopeBeanPage がnewされました。");
    }
    
    /** 
     * Initial Request時に呼出され、入力済みの内容をリセットする。
     */
    public String init() {
        logger.info("初期化します。");
        somethingDone = false;
        something = null;
        result = null;
        return null;
    }

    
    /**
     * 送信ボタンクリック時の処理を実行する。
     */
    public String doSomething() {
        logger.info("doSomething");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        somethingDone = true;
        result = something + "が入力されました";
        return null;
    }
    
    public String doAnotherThing() {
        logger.info("doAnotherThing");
        if (!somethingDone) {
            String message = "長時間経過したため、リセットされました。";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
            init();
            return null;
        }
        result = result + "(さらに何かされました)";
        return null;
    }
}
