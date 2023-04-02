package com.example.e_commerce.adapter;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.MainActivity;
import com.example.e_commerce.R;
import com.example.e_commerce.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    Context context;  //для создания страницы со списком
    List<Category> categories; //список всех наших категорий

    public CategoryAdapter(Context context, List<Category> categories) //просто конструктор с помощью которого мы установим контекст и лист
    {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  //мы указываем дизайн и с какими элементами мы будем работать
    {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false); //для всех наших элементов будет использован один дизайн
        return new CategoryViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) //что конкретно в кажое поле мы будем подставлять
    {
        holder.categoryTitle.setText(categories.get(position).getTitle()); //holder - это передаваемый параметр

        holder.itemView.setOnClickListener(new View.OnClickListener() {  //обработчик нажатия на категорию
            @Override
            public void onClick(View view) {
                MainActivity.showCoursesByCategory(categories.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView categoryTitle; //прописали с какими конкретными полями мы будем взаимодействовать

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = itemView.findViewById(R.id.categoryTitle); //
        }
    }

}
