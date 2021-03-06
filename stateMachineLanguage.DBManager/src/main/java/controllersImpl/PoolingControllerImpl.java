package controllersImpl;

import controllers.IPoolingController;
import domain.Pooling;
import servicesImpl.PoolingServiceImpl;

public class PoolingControllerImpl implements IPoolingController {

	PoolingServiceImpl poolingService = new PoolingServiceImpl();
	
	@Override
	public Iterable<Pooling> findAll() {
		return poolingService.findAll();
	}



	@Override
	public Pooling find(Long id) {
		return poolingService.find(id);
	}



	@Override
	public void delete(Long id) {
		poolingService.delete(id);
		
	}

	@Override
	public Pooling createOrUpdate(Pooling pool) {
		return poolingService.createOrUpdate(pool);
	}

	@Override
	public Pooling findByLayerpos(int layerpos) {
		try {
			return poolingService.findByLayerpos(layerpos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
