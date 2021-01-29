package InnerAndAbstractClassesAndInterface.InnerClasses;

public class StartEngine {
  private String title;
  private OnClickListener onClickLister;

  public StartEngine(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setOnClickListener(OnClickListener onClickListener) {
    this.onClickLister = onClickListener;
  }

  public void onClick() {
    this.onClickLister.onClick(this.title);
  }

  // class icerisinde bu interface i create etmek ile diger classlar da which are used this class as composition
  // kolaylikla anoymous class olarak define edilmesine ve methodlarin implement edilmesine yarar.

  public interface OnClickListener {
    public void onClick(String title);
  }
}
