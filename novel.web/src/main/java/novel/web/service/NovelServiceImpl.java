package novel.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import novel.spider.entitys.Novel;
import novel.web.mapper.NovelMapper;

@Service
public class NovelServiceImpl implements NovelService {
	@Resource
	private NovelMapper mapper;
	@Override
	public List<Novel> getsNovelByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return mapper.getsNovelByKeyword(keyword);
	}
	@Override
	public List<Novel> getsNovelByKeyword(String keyword, int platformId) {
		Map<String, String> map = new HashMap<>();
		map.put("keyword", "%" + keyword + "%");
		map.put("platformId", platformId + "");
		return mapper.getsNovelByKeyword2(map);
	}

}
