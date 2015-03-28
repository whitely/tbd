package affinity;

public class NullStrategy extends AffinityStrategy {

	@Override
	public int getAffinity(AFFINITY type) {
		return 0;
	}

}
