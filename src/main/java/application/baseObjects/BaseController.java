package application.baseObjects;

public abstract class BaseController<M extends BaseModel, V extends BaseView> {

    private M model;
    private V view;

    public BaseController(M model, V view) {
        this.model = model;
        this.view = view;
    }

    public void initialize() {
        view.updateView();
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }
}
