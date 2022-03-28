package controllersImpl;

import controllers.ITempLayerController;
import domain.TempLayer;
import servicesImpl.TempLayerServiceImpl;

public class TempLayerControllerImpl implements ITempLayerController {
	
	TempLayerServiceImpl tempLayerService = new TempLayerServiceImpl();

	@Override
	public Iterable<TempLayer> findAll() {
		return tempLayerService.findAll();
	}

	@Override
	public TempLayer find(Long id) {
		return tempLayerService.find(id);
	}

	@Override
	public void delete(Long id) {
		tempLayerService.delete(id);
		
	}

	@Override
	public TempLayer createOrUpdate(TempLayer tempLayer) {
		return tempLayerService.createOrUpdate(tempLayer);
	}

}
