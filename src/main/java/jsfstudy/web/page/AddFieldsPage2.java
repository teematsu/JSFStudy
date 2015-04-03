package jsfstudy.web.page;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;

@ManagedBean
@ViewScoped
@Slf4j
public class AddFieldsPage2 {
    public static class SubBean {
        @NotBlank @Size(max = 5)
        @Getter @Setter private String strField;
        @Getter boolean deleted = false;
    }
    
    
    @Getter private final List<SubBean> subBeans = new ArrayList<>();
    
    @Size(max = 3)
    @Getter @Setter private String anotherField;

    @PostConstruct
    public void init() {
        subBeans.add(new SubBean()); // 初期状態で1個だけ入力欄を用意。
    }
    
    
    public String addSubBean() {
        subBeans.add(new SubBean());
        return null;
    }
    
    public String removeSubBeanObject(SubBean subBean) {
        subBean.deleted = true;
        return null;
    }

    public String save() {
        List<SubBean> aliveSubBeans = filterAliveSubBeans();
        
        logger.info("繰り返しの入力欄の内容:");
        for (SubBean subBean: aliveSubBeans) {
            logger.info(" {}", subBean.strField);
        }
        logger.info("その他の入力欄の内容:");
        logger.info(" {}", anotherField);
        return null;
    }
    
    private List<SubBean> filterAliveSubBeans() {
        List<SubBean> filtered = new ArrayList<>();
        for (SubBean subBean: subBeans) {
            if (! subBean.deleted) {
                filtered.add(subBean);
            }
        }
        return filtered;
    }
}
