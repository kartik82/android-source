package io.bloc.android.blocly.api.model;

/**
 * Created by Kartik on 16-Oct-15.
 */
public abstract class Model {

    private final long rowId;

    public Model(long rowId) {
        this.rowId = rowId;
    }

    public long getRowId() {
        return rowId;
    }
}
