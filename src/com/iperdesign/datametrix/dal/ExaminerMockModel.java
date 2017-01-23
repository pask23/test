package com.iperdesign.datametrix.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.iperdesign.datametrix.bean.Examiner;
import com.iperdesign.datametrix.bean.User;
import com.iperdesign.datametrix.bean.UserType;
import com.iperdesign.datametrix.exception.ElementNotFoundException;

public class ExaminerMockModel {
	static HashMap<Integer, Examiner> examinerIdMap = getExaminerIdMap();

	public ExaminerMockModel() {
		super();

		if (examinerIdMap == null) {
			examinerIdMap = new HashMap<Integer, Examiner>();
			// Creating some object of countries while initializing
			
			UserType userType = new UserType(){{
				setId(1);
				setValue("Examiner");
			}};
			
			Examiner e1 = new Examiner(){{
				setId(1);
				setName("John");
				setSurname("E.");
				setUser(new User(){{
					setUsername("johne");
					setPassword("");
					setEmail("");
					setType(userType);
				}});
			}};
			
			Examiner e2 = new Examiner(){{
				setId(2);
				setName("Bobby");
				setSurname("b.");
				setUser(new User(){{
					setUsername("bobbyb");
					setPassword("");
					setEmail("");
					setType(userType);
				}});
			}};
			
			Examiner e3 = new Examiner(){{
				setId(3);
				setName("Lisa");
				setSurname("L.");
				setUser(new User(){{
					setUsername("lisal");
					setPassword("");
					setEmail("");
					setType(userType);
				}});
			}};
			
			Examiner e4 = new Examiner(){{
				setId(4);
				setName("Bill");
				setSurname("E.");
				setUser(new User(){{
					setUsername("bille");
					setPassword("");
					setEmail("");
					setType(userType);
				}});
			}};
			

			examinerIdMap.put(1, e1);
			examinerIdMap.put(4, e2);
			examinerIdMap.put(3, e3);
			examinerIdMap.put(2, e4);
		}
	}

	public List<Examiner> getAllExaminers() {
		List<Examiner> examiners = new ArrayList<Examiner>(examinerIdMap.values());
		return examiners;
	}

	public Examiner getExaminer(int id) {
		Examiner examiner = examinerIdMap.get(id);
		
//		if (examiner == null) {
//			throw new ElementNotFoundException("Examiner with id " + id + " not found");
//		}
		return examiner;
	}

	public Examiner addExaminer(Examiner examiner) {
		examiner.setId(getMaxId() + 1);
		examinerIdMap.put(examiner.getId(), examiner);
		return examiner;
	}

	public Examiner updateExaminer(Examiner examiner) {
		Examiner ex = examinerIdMap.put(examiner.getId(), examiner);
		return ex;
	}

	public boolean deleteExaminer(int id) {
		if(examinerIdMap.remove(id)!=null)
			return true;
		return false;
	}

	public static HashMap<Integer, Examiner> getExaminerIdMap() {
		return examinerIdMap;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : examinerIdMap.keySet()) {
			if (max <= id)
				max = id;
		}
		return max;
	}

}
