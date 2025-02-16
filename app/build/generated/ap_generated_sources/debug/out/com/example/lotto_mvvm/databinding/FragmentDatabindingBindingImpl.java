package com.example.lotto_mvvm.databinding;
import com.example.lotto_mvvm.R;
import com.example.lotto_mvvm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentDatabindingBindingImpl extends FragmentDatabindingBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.datab_title, 2);
        sViewsWithIds.put(R.id.datab_getlotto, 3);
        sViewsWithIds.put(R.id.datab_lottolist, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentDatabindingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private FragmentDatabindingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.AppCompatButton) bindings[3]
            , (android.widget.TextView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.databLottoCurrentNumber.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.datamodel == variableId) {
            setDatamodel((com.example.lotto_mvvm.ui.exdata.viewModel.DataViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDatamodel(@Nullable com.example.lotto_mvvm.ui.exdata.viewModel.DataViewModel Datamodel) {
        this.mDatamodel = Datamodel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.datamodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeDatamodelCurrentNumber((kotlinx.coroutines.flow.MutableStateFlow<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeDatamodelCurrentNumber(kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> DatamodelCurrentNumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String datamodelCurrentNumberGetValue = null;
        kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> datamodelCurrentNumber = null;
        com.example.lotto_mvvm.ui.exdata.viewModel.DataViewModel datamodel = mDatamodel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (datamodel != null) {
                    // read datamodel.currentNumber
                    datamodelCurrentNumber = datamodel.getCurrentNumber();
                }
                androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 0, datamodelCurrentNumber);


                if (datamodelCurrentNumber != null) {
                    // read datamodel.currentNumber.getValue()
                    datamodelCurrentNumberGetValue = datamodelCurrentNumber.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.databLottoCurrentNumber, datamodelCurrentNumberGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): datamodel.currentNumber
        flag 1 (0x2L): datamodel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}