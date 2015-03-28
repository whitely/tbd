package affinity;

public abstract class AffinityStrategy {
	public enum AFFINITY {RIFT, NEXUS};
	
	public abstract int getAffinity(AFFINITY type);
	
}
