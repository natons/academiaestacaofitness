package mvc.model;

/**
 *
 * @author Luciana
 */
public class ExercicioTipo {
   private int idExerciciotipo;
   private Exercicio exercicio;
   private Tipo tipo;

    public int getIdExerciciotipo() {
        return idExerciciotipo;
    }

    public void setIdExerciciotipo(int idExerciciotipo) {
        this.idExerciciotipo = idExerciciotipo;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ExercicioTipo() {
    }

    public ExercicioTipo(int idExerciciotipo, Exercicio exercicio, Tipo tipo) {
        this.idExerciciotipo = idExerciciotipo;
        this.exercicio = exercicio;
        this.tipo = tipo;
    }
    
    
}
