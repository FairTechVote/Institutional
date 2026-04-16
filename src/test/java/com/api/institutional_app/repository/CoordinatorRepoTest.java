package com.api.institutional_app.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.institutional_app.entity.Coordinator;

@ExtendWith(MockitoExtension.class)
@DisplayName("Coordinator Repository Unit Tests")
class CoordinatorRepoTest {

    @Mock
    private CoordinatorRepo coordinatorRepo;

    private Coordinator coordinator;

    @BeforeEach
    void setUp() {
        coordinator = new Coordinator();
        coordinator.setId(1L);
        coordinator.setName("John Doe");
        coordinator.setEmail("coordinator@email.com");
        coordinator.setCpf("12345678900");
    }

    @Test
    @DisplayName("Test to find by email")
    void testFindByEmail() {
        String email = "coordinator@email.com";
        when(coordinatorRepo.findByEmail(email)).thenReturn(Optional.of(coordinator));
        Optional<Coordinator> found = coordinatorRepo.findByEmail(email);
        assertTrue(found.isPresent());
        assertEquals(coordinator.getEmail(), found.get().getEmail());
        verify(coordinatorRepo, times(1)).findByEmail(email);
    }

    @Test
    @DisplayName("test to return empty when email not found")
    void testFindByEmailNotFound() {
        when(coordinatorRepo.findByEmail("coordinator@nonexists.com"))
                .thenReturn(Optional.empty());
        Optional<Coordinator> found = coordinatorRepo.findByEmail("coordinator@nonexists.com");
        assertFalse(found.isPresent());
        verify(coordinatorRepo, times(1)).findByEmail("coordinator@nonexists.com");
    }

    @Test
    @DisplayName("Test to find by cpf")
    void testFindByCpf() {
        String cpf = coordinator.getCpf();
        when(coordinatorRepo.findByCpf(cpf)).thenReturn(Optional.of(coordinator));
        Optional<Coordinator> found = coordinatorRepo.findByCpf(cpf);
        assertTrue(found.isPresent());
        assertEquals(coordinator.getCpf(), found.get().getCpf());
        verify(coordinatorRepo, times(1)).findByCpf(cpf);
    }

    @Test
    @DisplayName("test to return empty when cpf not found")
    void testFindByCpfNotFound() {
        when(coordinatorRepo.findByCpf("99999999999"))
                .thenReturn(Optional.empty());
        Optional<Coordinator> found = coordinatorRepo.findByCpf("99999999999");
        assertFalse(found.isPresent());
        verify(coordinatorRepo, times(1)).findByCpf("99999999999");
    }

}
