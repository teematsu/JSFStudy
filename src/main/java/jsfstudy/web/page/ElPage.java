package jsfstudy.web.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;

@ManagedBean
@RequestScoped
public class ElPage {
    @Getter private final String nullValue = null;
    @Getter private final String pre = "1";
    @Getter private final String post = "2";
}
