package mx.uv.fiee.iinf.gallerydemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryItemVH> {
    Context context;
    LinkedList<Uri> imageUris;

    public GalleryAdapter (Context context, LinkedList<Uri> imageUris) {
        this.context = context;
        this.imageUris = imageUris;
    }

    @NonNull
    @Override
    public GalleryAdapter.GalleryItemVH onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (this.context).inflate (R.layout.gallery_item, parent, false);
        return new GalleryItemVH (view);
    }

    @Override
    public void onBindViewHolder (@NonNull GalleryAdapter.GalleryItemVH holder, int position) {
        Uri image = imageUris.get (position);
        holder.setImage (image);
        //FUNCION QUE AL DAR CLIC A ALGUNA IMAGEN NOS MANDA A LA VISTA DE "SAVING ACTIVITY"
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), SavingActivity.class);
                //intent.putExtra("list_item", "");
                holder.itemView.getContext().startActivity(intent);
            }
        });
         */
    }

    @Override
    public int getItemCount() {
        return imageUris.size ();
    }

    protected class GalleryItemVH extends RecyclerView.ViewHolder {
        ImageView imageView;

        public GalleryItemVH(@NonNull View itemView) {
            super (itemView);
            imageView = itemView.findViewById (R.id.ivGalleryItem);
        }

        void setImage (Uri image) {
            Picasso.get().load (image).into(imageView);
        }
    }

}
