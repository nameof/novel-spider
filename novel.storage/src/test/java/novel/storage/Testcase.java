package novel.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import novel.storage.impl.BxwxNovelStorageImpl;
import novel.storage.impl.KanShuZhongNovelStorageImpl;

public class Testcase {
	@Test
	public void testMybatisConnection () throws Exception {
		SqlSession session = new SqlSessionFactoryBuilder().build(new FileInputStream("conf/SqlMapConfig.xml")).openSession();
		System.out.println(session);
	}
	
	@Test
	public void testKanShuZhongProcess() throws Exception {
		Processor processor = new KanShuZhongNovelStorageImpl();
		processor.process();
	}
	@Test
	public void testBxwxProcess() throws FileNotFoundException {
		Processor processor = new BxwxNovelStorageImpl();
		processor.process();
	}
}
