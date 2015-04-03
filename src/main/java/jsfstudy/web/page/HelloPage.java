package jsfstudy.web.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class HelloPage {
    @Getter @Setter private String yourName;

    public String getMessage() {
        return "Hello, " + yourName + "!";
    }
    
    public String sayHello() {
        return null;
    }
}
