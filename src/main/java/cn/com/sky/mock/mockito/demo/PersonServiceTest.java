package cn.com.sky.mock.mockito.demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * <pre>
 * mock对象就是在调试期间用来作为真实对象的替代品。
 * mock测试就是在测试过程中，对那些不容易构建的对象用一个虚拟对象来代替测试的方法就叫mock测试。
 * 
 * 
 * </pre>
 */
public class PersonServiceTest {

	@Mock
	private PersonDao personDAO;

	private PersonService personService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		personService = new PersonService(personDAO);
	}

	@Test
	public void shouldUpdatePersonName() {
		Person person = new Person(1, "Phillip");
		when(personDAO.fetchPerson(1)).thenReturn(person);
		boolean updated = personService.update(1, "David");
		assertTrue(updated);
		verify(personDAO).fetchPerson(1);
		ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
		verify(personDAO).update(personCaptor.capture());
		Person updatedPerson = personCaptor.getValue();
		assertEquals("David", updatedPerson.getPersonName());
		// asserts that during the test, there are no other calls to the mock object.
		verifyNoMoreInteractions(personDAO);
	}

	@Test
	public void shouldNotUpdateIfPersonNotFound() {
		when(personDAO.fetchPerson(1)).thenReturn(null);
		boolean updated = personService.update(1, "David");
		assertFalse(updated);
		verify(personDAO).fetchPerson(1);
		verifyZeroInteractions(personDAO);
		verifyNoMoreInteractions(personDAO);
	}
}