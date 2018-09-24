package unalcol.agents.search;
import unalcol.types.collection.vector.*;
import unalcol.types.object.tagged.Tagged;
import unalcol.agents.*;
import unalcol.search.BasicGoalBased;
import unalcol.search.Goal;
import unalcol.search.local.LocalSearch;
import unalcol.search.space.Space;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: Universidad Nacional de Colombia</p>
 *
 * @author Jonatan Gómez
 * @version 1.0
 */
public abstract class GraphSearch<T> extends BasicGoalBased<T, Boolean> implements LocalSearch<T,Boolean>{
	public abstract Vector<Action> apply( T initial, GraphSpace<T> space, Goal<T,Boolean> goal, ActionCost<T> cost  );
  
	public Tagged<T> apply( Tagged<T> x, Space<T> space ){
		GraphSpace<T> g_space = (GraphSpace<T>)space;
		Goal<T,Boolean> goal = goal();
		ActionCost<T> cost = g_space.cost();
		Vector<Action> action = apply( x.unwrap(), g_space, goal, cost);
		PathUtil<T> path = new PathUtil<T>();
		T y = path.final_state(x.unwrap(), g_space, action);
		Tagged<T> sol = new Tagged<T>(y);
		sol.setTag(PathUtil.class.getName(), action);
		return sol;
	}
}