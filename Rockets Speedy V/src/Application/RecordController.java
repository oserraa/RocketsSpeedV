package Application;

import Persistence.RecordRepository;
import Application.RecordDTO;
import Domain.Record;;

public class RecordController {

	public RecordDTO createRecord(RecordDTO recordDTO) throws Exception {
		Record record = new Record(recordDTO);
		RecordRepository.storeRecord(record);
		return new RecordDTO(record);
	}

	public RecordDTO getRecord(String circuit) throws Exception {
		Record record = RecordRepository.getRecord(circuit);
		return new RecordDTO(record);
	}

	public RecordDTO updateRecord(String circuit, RecordDTO recordDTO) throws Exception {
	  
		Record record= RecordRepository.getRecord(circuit);
		record.updateRecord(recordDTO);
		RecordRepository.updateRecord(record);
		return new RecordDTO(record);
		
		
	}
}
