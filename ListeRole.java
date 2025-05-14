import java.util.*;

public class ListeRole {
    private List<Role> roles;

    public ListeRole() {
        this.roles = new ArrayList<>();
    }

    public void ajouterRole(Role role) {
        this.roles.add(role);
    }

    public Role getRoleByNom(String nomRole) {
        for (Role role : roles) {
            if (role.getNomRole().equals(nomRole)) {
                return role;
            }
        }
        return null;
    }

    public void afficherRoles() {
        System.out.println("Liste des rôles disponibles :");
        for (Role role : roles) {
            System.out.println("- " + role.getNomRole());
        }
    }
}
