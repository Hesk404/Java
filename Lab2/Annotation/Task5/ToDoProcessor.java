package Lab2.Annotation.Task5;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Set;


@SupportedAnnotationTypes("Lab2.Annotation.Task5.ToDo")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class ToDoProcessor extends AbstractProcessor
{
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment re)
	{
		if(annotations.isEmpty()) return true;
		
		try(FileWriter writer = new FileWriter("ToDo.log"))
		{
			Set<?> elements = re.getElementsAnnotatedWith(ToDo.class);
			StringBuilder sb = new StringBuilder();
			
			sb.append("TODO RESULT: \r\n");
			
			for(Object o : elements) 
			{
				Element element = (Element) o;
				sb.append(element.getKind()).append(": ").append(element.getSimpleName()).append(" => ");
				sb.append(element.getAnnotation(ToDo.class).message()).append("\r\n");
			}
			
			processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, sb.toString());
			writer.write(sb.toString());
			
			writer.close();
			
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
}


