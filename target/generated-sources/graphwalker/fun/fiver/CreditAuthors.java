// Generated by GraphWalker (http://www.graphwalker.org)
package fun.fiver;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "fun/fiver/CreditAuthors.json")
public interface CreditAuthors {

    @Vertex()
    void v_Home();

    @Vertex()
    void v_Settings();

    @Vertex()
    void v_NavigationDrawer();

    @Edge()
    void e_OpenAbout();

    @Edge()
    void e_GrantPermission();

    @Vertex()
    void v_About();

    @Edge()
    void e_OpenSettings();

    @Edge()
    void e_OpenNavigationDrawer();

    @Vertex()
    void v_StartState();

    @Edge()
    void e_CheckAuthors();
}
