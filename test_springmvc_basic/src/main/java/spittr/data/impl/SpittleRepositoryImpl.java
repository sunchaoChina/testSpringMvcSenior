package spittr.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import spittr.data.SpittleRepository;
import spittr.pojo.Spittle;
@Service
public class SpittleRepositoryImpl implements SpittleRepository{

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}

	@Override
	public Spittle findOne(long spittleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
