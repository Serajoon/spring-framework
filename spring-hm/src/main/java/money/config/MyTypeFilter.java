package money.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {
	/**
	 * Determine whether this filter matches for the class described by
	 * the given metadata.
	 *
	 * @param metadataReader        the metadata reader for the target class    读取到得当前正在扫描的类的信息
	 * @param metadataReaderFactory a factory for obtaining metadata readers    一个可以探索其他类信息的工厂类
	 *                              for other classes (such as superclasses and interfaces)
	 * @return whether this filter matches
	 */
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
		// 获取当前类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取当前类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		// 获取当前类的资源（类的路径）
		Resource resource = metadataReader.getResource();
		String className = classMetadata.getClassName();
		System.out.println("----" + className);
		//过滤不以son结尾的component
		if (className.endsWith("son")) {
			return true;
		}
		return false;
//		return true;
	}
}