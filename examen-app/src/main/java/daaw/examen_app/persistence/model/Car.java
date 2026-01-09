/* RANKING MODEL
 * id
 * playerName
 * level
 * lines
 */

package daaw.examen_app.persistence.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import daaw.examen_app.persistence.model.Maintenance;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "La matricula no puede estar vacia")
    private String matricula;

    @Column(nullable = false)
    @NotNull(message = "El año de matriculacion no puede estar vacio")
    private int anoMatriculacion;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Maintenance> mantenimientos = new ArrayList<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoMatriculacion() {
        return anoMatriculacion;
    }

    public void setLevel(int anoMatriculacion) {
        this.anoMatriculacion = anoMatriculacion;
    }

    public void addMaintenance (Maintenance m) {
        mantenimientos.add(m);
    }

    public List<Maintenance> getMaintenance () {
        return mantenimientos;
    }

    
    @Override 
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
            Car other = (Car) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ranking [id=" + id + ", Matricula=" + matricula + ", Año Matriculacion=" + anoMatriculacion + "Mantenimientos: " + mantenimientos + "]";
    }
}
