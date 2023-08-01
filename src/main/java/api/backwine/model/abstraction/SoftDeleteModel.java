package api.backwine.model.abstraction;

public interface SoftDeleteModel<I> extends GenericModel<I> {
    void setDeleted(boolean isDeleted);
}
