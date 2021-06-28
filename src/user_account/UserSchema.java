package user_account;

import java.io.IOException;
import java.util.List;

public abstract class UserSchema {

	public abstract boolean checkUsername(String username)throws IOException;
	public abstract boolean loginUsername(String username)throws IOException;
	public abstract boolean loginPassword(int count, String password)throws IOException;
	public abstract void createDir(String username)throws IOException;
	public abstract void addRecord(String add, String username, String recName) throws IOException;
	public abstract List<String> readRecord(String username, String recName) throws IOException;
	public abstract void attendanceSet(String username, String recName);
	public abstract void recordAttendance(int count,char state , String username, String recName) throws IOException;
	public abstract void editRecord(int selected, String newData, String username, String recordName) throws IOException;
	public abstract void deleteRecord(int selected, int type, String username, String recName) throws IOException;
}
