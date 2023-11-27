package com.example.todoapp.ui.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.todoapp.data.entity.ToDo;
import com.example.todoapp.databinding.CardTasarimBinding;
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections;
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

public class TDAdapter extends RecyclerView.Adapter<TDAdapter.CardTasarimTutucu> {
    private List<ToDo> toDoListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;

    public TDAdapter(List<ToDo> toDoListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.toDoListesi = toDoListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public static class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        ToDo td = toDoListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewTd.setText(td.getName());

        t.delete.setOnClickListener(v -> {
            Snackbar.make(v,td.getName()+" Do you want to delete?",Snackbar.LENGTH_SHORT)
                    .setAction("YES",v1 -> {
                        viewModel.sil(td.getId());
                    })
                    .show();
        });

        t.cardViewSatir.setOnClickListener(v -> {
            AnasayfaFragmentDirections.TdDetayGecis gecis = AnasayfaFragmentDirections.tdDetayGecis(td);
            Navigation.findNavController(v).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {
        return toDoListesi.size();
    }
}
