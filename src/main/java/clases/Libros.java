package clases;
public class Libros {
private int id;
private String titulo;
private String autor;
private String Disponible;
private Categorias cate;
public Libros(){
    
}
public Libros(int id,String titulo,String autor,String disponible,Categorias cate){
 this.id=id;
 this.titulo=titulo;
 this.autor=autor;
 this.Disponible=disponible;
 this.cate=cate;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisponible() {
        return Disponible;
    }

    public void setDisponible(String Disponible) {
        this.Disponible = Disponible;
    }

    public Categorias getCate() {
        return cate;
    }

    public void setCate(Categorias cate) {
        this.cate = cate;
    }

}
