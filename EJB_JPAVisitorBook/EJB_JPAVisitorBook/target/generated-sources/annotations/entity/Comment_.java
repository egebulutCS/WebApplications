package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-27T17:30:14")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, String> comment_str;
    public static volatile SingularAttribute<Comment, String> name;
    public static volatile SingularAttribute<Comment, Date> visitDate;
    public static volatile SingularAttribute<Comment, Long> id;

}