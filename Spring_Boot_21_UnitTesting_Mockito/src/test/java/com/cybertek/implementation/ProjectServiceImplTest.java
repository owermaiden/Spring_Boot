package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.entity.Project;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode() {

        Project project = new Project();           // we created empty project and project DTO...
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findByProjectCode("PR01")).thenReturn(project);  // we say -> when you try to call findbyprojectCode()... then return my project as a mock...
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);       // and use my project and then return project dto which I created...

        ProjectDTO projectDTO1 = projectService.getByProjectCode("PR01");

        verify(projectRepository).findByProjectCode(Mockito.anyString());
        verify(projectMapper).convertToDto(Mockito.any(Project.class));

        assertNotNull(projectDTO1); // verify that our getByProjectCode method returns not null...
    }

    @Test
    void getByProjectCode_exception_test(){

        // if any empty string to repository happens, then throw exeption... Bunu biz hazırlıyoruz...
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));

        // Sonra test ettiğimiz methoda gerçekten empty string gönderiyoruz... Bu bir exeption döndürmeli... yukarıda öyle belirledik...
        Throwable exception = assertThrows(RuntimeException.class,() -> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode(Mockito.anyString());  // verify projectrepo.findbyprojectcode() is working..

        // Sonra bakıyoruz gerçekten bizim verdiğimiz hatayı fırlatıyor mu?..
        assertEquals(exception.getMessage(),"Project Not Found");

    }
    @Test
    void saveTest(){
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        verify(projectRepository).save(project); // verify project repository save method called with our project object..

    }


}