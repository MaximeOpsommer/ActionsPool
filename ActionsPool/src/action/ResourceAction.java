package action;

import pool.Resource;
import pool.ResourcePool;
import pool.ResourcefulUser;

public class ResourceAction<T extends Resource> extends Action {
	
	ResourcePool<T> pool;
	ResourcefulUser<T> user;

	/**
	 * the constructor of a resource action
	 * @param timeToEnd the duration of the action
	 * @param pool the resource pool
	 * @param user the resourceful user
	 */
	public ResourceAction(int timeToEnd, ResourcePool<T> pool, ResourcefulUser<T> user) {
		super(timeToEnd);
		super.remainingTime = timeToEnd;
		this.pool = pool;
		this.user = user;
	}
	
	@Override
	public boolean isReady() {
		return remainingTime == totalTime;
	}

	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}
	
	@Override
	public boolean isFinished() {
		return remainingTime <= 0;
	}

	@Override
	public void doStep() {
		remainingTime--;
	}

}
