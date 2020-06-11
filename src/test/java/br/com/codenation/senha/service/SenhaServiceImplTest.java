package br.com.codenation.senha.service;


import br.com.codenation.senha.repository.SenhaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class SenhaServiceImplTest {


    @Mock
    private SenhaRepository senhaRepository;

    @InjectMocks
    private SenhaServiceImpl livroServiceImpl;

    @Test
    public void testFindMaiorMediaAvaliacao() {
        //mockFindLivrosComAvaliacao();
        //assertEquals(new Integer(4), java.util.Optional.of(SenhaServiceImpl.findByMaiorMediaAvaliacao().getMediaAvaliacoes()));
    }

    private void mockFindLivrosComAvaliacao() {
        //Senha evento = mock(Senha.class);
        //when(evento.getMediaAvaliacoes()).thenReturn(4);
        //when(this.senhaRepository.findComAvaliacao()).thenReturn(Arrays.asList(evento));
    }


}
