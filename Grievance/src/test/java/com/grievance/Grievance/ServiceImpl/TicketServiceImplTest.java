package com.grievance.Grievance.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.grievance.Grievance.Enum.TicketStatus;
import com.grievance.Grievance.Enum.TicketType;
import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.InDto.TicketInDto;
import com.grievance.Grievance.InDto.TicketUpdateDto;
import com.grievance.Grievance.OutDto.TicketOutDto;
import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Department;
import com.grievance.Grievance.entity.Ticket;
import com.grievance.Grievance.entity.UserDetails;
import com.grievance.Grievance.repository.CommentRepository;
import com.grievance.Grievance.repository.DepartmentRepository;
import com.grievance.Grievance.repository.TicketRepository;
import com.grievance.Grievance.repository.UserRepository;
import com.grievance.Grievance.serviceImplementation.TicketServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {

	@Mock
	private TicketRepository ticketRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private DepartmentRepository departmentRepository;
	@Mock
	private CommentRepository commentRepository;

	@InjectMocks
	private TicketServiceImpl ticketService;

	@Test
	public void testGetAllTickets_Administrator_All_MyTickets() {

		String email = "admin@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "All";

		UserDetails adminUser = new UserDetails();
		adminUser.setUsertype(UserType.Admin);
		adminUser.setEmail(email);

		Department department = new Department();
		department.setDeptName("AdminDept");

		List<Ticket> adminTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(adminTickets);

		when(userRepository.findByEmail(email)).thenReturn(adminUser);
		when(ticketRepository.findByUserDetails(
				argThat(user -> user.getUsertype() == UserType.Admin && user.getEmail().equals(email)),
				any(PageRequest.class))).thenReturn(ticketPage);
		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(adminTickets.size(), result.size());
	}


	@Test
	public void testGetAllTickets_Administrator_All_All() {

		String email = "admin@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "All";
		String filter = "All";

		UserDetails adminUser = new UserDetails();
		adminUser.setUsertype(UserType.Admin);
		adminUser.setEmail(email);
		adminUser.getDepartment();

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> adminTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(adminTickets);

		when(userRepository.findByEmail(email)).thenReturn(adminUser);
		when(ticketRepository.findAll(pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(adminTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Administrator_MyTicket_Open1() {

		String email = "admin@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "Open";

		TicketStatus ticketStatus = TicketStatus.valueOf(filter);

		UserDetails adminUser = new UserDetails();
		adminUser.setUsertype(UserType.Admin);
		adminUser.setEmail(email);
		adminUser.getDepartment();

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> adminTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(adminTickets);

		when(userRepository.findByEmail(email)).thenReturn(adminUser);
		when(ticketRepository.findByUserDetailsAndTicketStatus(adminUser, ticketStatus, pageable))
				.thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(adminTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Administrator_MyTicket_Open() {
		testGetAllTicketsForFilter("Open");
	}

	@Test
	public void testGetAllTickets_Administrator_MyTicket_Being_Addressed() {
		testGetAllTicketsForFilter("Being_Addressed");
	}

	@Test
	public void testGetAllTickets_Administrator_MyTicket_Resolved() {
		testGetAllTicketsForFilter("Resolved");
	}

	private void testGetAllTicketsForFilter(String filter) {
		String email = "admin@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "OtherTypes";

		TicketStatus ticketStatus = TicketStatus.valueOf(filter);

		UserDetails adminUser = new UserDetails();
		adminUser.setUsertype(UserType.Admin);
		adminUser.setEmail(email);
		adminUser.getDepartment();

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> adminTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(adminTickets);

		when(userRepository.findByEmail(email)).thenReturn(adminUser);

		if (type.equals("My Ticket")) {
			when(ticketRepository.findByUserDetailsAndTicketStatus(adminUser, ticketStatus, pageable))
					.thenReturn(ticketPage);
		} else if (type.equals("My Department")) {
			when(ticketRepository.findByDepartmentAndTicketStatus(department, ticketStatus, pageable))
					.thenReturn(ticketPage);
		} else {
			when(ticketRepository.findByTicketStatus(ticketStatus, pageable)).thenReturn(ticketPage);
		}
		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(adminTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Administrator_OtherType_Open() {
		String email = "admin@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "OtherType"; // A type other than "My Ticket" or "My Department"
		String filter = "Open";

		TicketStatus ticketStatus = TicketStatus.valueOf(filter);

		UserDetails adminUser = new UserDetails();
		adminUser.setUsertype(UserType.Admin);
		adminUser.setEmail(email);
		adminUser.getDepartment();

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> adminTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(adminTickets);

		when(userRepository.findByEmail(email)).thenReturn(adminUser);
		when(ticketRepository.findByTicketStatus(ticketStatus, pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(adminTickets.size(), result.size());
	}
	@Test
	public void testGetAllTickets_Administrator_MyTicket_BeingAddressed() {
		String email = "admin@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "Being_Addressed";

		TicketStatus ticketStatus = TicketStatus.valueOf(filter);

		UserDetails adminUser = new UserDetails();
		adminUser.setUsertype(UserType.Admin);
		adminUser.setEmail(email);
		adminUser.getDepartment();

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> adminTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(adminTickets);

		when(userRepository.findByEmail(email)).thenReturn(adminUser);
		when(ticketRepository.findByUserDetailsAndTicketStatus(adminUser, ticketStatus, pageable))
				.thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(adminTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Member_All_MyTickets() {
		String email = "member@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "All";
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		UserDetails memberUser = new UserDetails();
		memberUser.setUsertype(UserType.Member);
		memberUser.setEmail(email);
		memberUser.setDepartment(department);

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> memberTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(memberTickets);

		when(userRepository.findByEmail(email)).thenReturn(memberUser);
		when(ticketRepository.findByUserDetails(memberUser, pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(memberTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Member_All_All() {
		String email = "member@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "All";
		String filter = "All";

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		UserDetails memberUser = new UserDetails();
		memberUser.setUsertype(UserType.Member);
		memberUser.setEmail(email);
		memberUser.setDepartment(department);

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> memberTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(memberTickets);

		when(userRepository.findByEmail(email)).thenReturn(memberUser);
		when(ticketRepository.findByUserDetailsOrDepartment(memberUser, department, pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(memberTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Member_All_MyDepartment() {
		String email = "member@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Department";
		String filter = "All";
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		UserDetails memberUser = new UserDetails();
		memberUser.setUsertype(UserType.Member);
		memberUser.setEmail(email);
		memberUser.setDepartment(department);

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> memberTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(memberTickets);

		when(userRepository.findByEmail(email)).thenReturn(memberUser);
		when(ticketRepository.findByDepartment(department, pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(memberTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Member_All_Open() {
		String email = "member@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "All";
		String filter = "Open";

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");
		UserDetails memberUser = new UserDetails();
		memberUser.setUsertype(UserType.Member);
		memberUser.setEmail(email);
		memberUser.setDepartment(department);

		TicketStatus ticketStatus = TicketStatus.valueOf(filter);

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> memberTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(memberTickets);

		when(userRepository.findByEmail(email)).thenReturn(memberUser);
		when(ticketRepository.findByTicketStatusAndDepartmentOrUserDetails(department, memberUser, ticketStatus,
				pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(memberTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Member_MyTicket_BeingAddressed() {
		String email = "member@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "Being_Addressed";

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");

		UserDetails memberUser = new UserDetails();
		memberUser.setUsertype(UserType.Member);
		memberUser.setEmail(email);
		memberUser.setDepartment(department);

		TicketStatus ticketStatus = TicketStatus.Being_Addressed;

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> memberTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(memberTickets);

		when(userRepository.findByEmail(email)).thenReturn(memberUser);
		when(ticketRepository.findByUserDetailsAndTicketStatus(memberUser, ticketStatus, pageable))
				.thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(memberTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Member_All_BeingAddressed() {
		String email = "member@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "All";
		String filter = "Being_Addressed";

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");
		UserDetails memberUser = new UserDetails();
		memberUser.setUsertype(UserType.Member);
		memberUser.setEmail(email);
		memberUser.setDepartment(department);

		TicketStatus ticketStatus = TicketStatus.Being_Addressed;

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> memberTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(memberTickets);

		when(userRepository.findByEmail(email)).thenReturn(memberUser);
		when(ticketRepository.findByTicketStatusAndDepartmentOrUserDetails(department, memberUser, ticketStatus,
				pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(memberTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_Member_MyDepartment_BeingAddressed() {
		String email = "member@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Department";
		String filter = "Being_Addressed";
		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("AdminDept");
		UserDetails memberUser = new UserDetails();
		memberUser.setUsertype(UserType.Member);
		memberUser.setEmail(email);
		memberUser.setDepartment(department);

		TicketStatus ticketStatus = TicketStatus.Being_Addressed;

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> memberTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(memberTickets);

		when(userRepository.findByEmail(email)).thenReturn(memberUser);
		when(ticketRepository.findByDepartmentAndTicketStatus(department, ticketStatus, pageable))
				.thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);
		assertEquals(memberTickets.size(), result.size());
	}

	@Test
	public void testGetAllTickets_GenerateTicketOutDto() {
		String email = "admin@nculeusteq.com";
		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "All";

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		List<Ticket> adminTickets = new ArrayList<>();
		Page<Ticket> ticketPage = new PageImpl<>(adminTickets);

		UserDetails adminUser = new UserDetails();
		adminUser.setUsertype(UserType.Admin);
		adminUser.setEmail(email);
		adminUser.getDepartment();

		Department department = new Department();
		department.setDeptName("AdminDept");

		when(userRepository.findByEmail(email)).thenReturn(adminUser);
		when(ticketRepository.findByUserDetails(adminUser, pageable)).thenReturn(ticketPage);

		List<TicketOutDto> result = ticketService.getAllTickets(pageNumber, pageSize, email, type, filter);

		assertNotNull(result);

		assertEquals(adminTickets.size(), result.size());

	}

	@Test
	public void testCreateTicket_Returns_TicketObject() {

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("SampleDept");

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setName("SampleUser");

		TicketInDto ticketInDto = new TicketInDto();
		ticketInDto.setDepartment(department);
		ticketInDto.setUserDetails(userDetails);
		ticketInDto.setDescription("SampleDescription");

		Ticket savedTicket = new Ticket();
		savedTicket.setTicketId(1);
		savedTicket.setDepartment(department);
		savedTicket.setUserDetails(userDetails);
		savedTicket.setDescription("SampleDescription");

		when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(department));
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(userDetails));
		when(ticketRepository.save(any(Ticket.class))).thenReturn(savedTicket);

		TicketOutDto ticketOutDto = ticketService.createTicket(ticketInDto);

		assertNotNull(ticketOutDto);
		assertEquals("SampleDept", ticketOutDto.getDeptName());
		assertEquals("SampleUser", ticketOutDto.getName());
		assertEquals("SampleDescription", ticketOutDto.getDescription());

		verify(ticketRepository, times(1)).save(any(Ticket.class));
	}

	@Test
	public void testGetTicketById_ReturnsTicketObject() {

		Department department = new Department();
		department.setDeptId(1);
		department.setDeptName("dept");

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setName("sneha");
		userDetails.setDepartment(department);

		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setTicketTitle("SampleTicket");
		ticket.setDepartment(department);
		ticket.setUserDetails(userDetails);

		when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));

		TicketOutDto ticketOutDto = ticketService.getTicketById(1L);

		assertEquals(1, ticketOutDto.getTicketId());
		assertEquals("SampleTicket", ticketOutDto.getTicketTitle());

		verify(ticketRepository, times(1)).findById(1L);
	}

	@Test
	public void testUpdateTicket() {

		Ticket mockTicket = new Ticket();
		mockTicket.setTicketId(1L);
		mockTicket.setComments(new ArrayList<Comment>());
		mockTicket.setCreatedAt(new Date());
		mockTicket.setDepartment(new Department());
		mockTicket.setDescription("abcd");
		mockTicket.setTicketStatus(TicketStatus.Open);
		mockTicket.setTicketTitle("title");
		mockTicket.setTicketType(TicketType.Grievance);
		mockTicket.setUpdatedAt(new Date());
		mockTicket.setUserDetails(new UserDetails());

		TicketUpdateDto ticketUpdateDto = new TicketUpdateDto();
		ticketUpdateDto.setContent("abcde");
		ticketUpdateDto.setTicketStatus(TicketStatus.Open);
		ticketUpdateDto.setUserId(1);

		UserDetails mockUserDetails = new UserDetails();
		mockUserDetails.setUserId(1);
		mockUserDetails.setDepartment(new Department());
		mockUserDetails.setEmail("sneha@nucleusteq.com");
		mockUserDetails.setIsLoggedIn(true);
		mockUserDetails.setName("Sneha");
		mockUserDetails.setPassword("password");
		mockUserDetails.setTickets(new ArrayList<Ticket>());
		mockUserDetails.setUsertype(UserType.Member);

		Comment mockComment = new Comment();
		mockComment.setCommentId(1);
		mockComment.setContent("abcde");
		mockComment.setLastUpdatedAt(new Date());
		mockComment.setMemberName("Sneha");
		mockComment.setTicket(mockTicket);

		List<Comment> commentList = new ArrayList<Comment>();
		commentList.add(mockComment);
		mockTicket.setComments(commentList);

		when(commentRepository.save(any(Comment.class))).thenReturn(mockComment);

		when(userRepository.findById(ticketUpdateDto.getUserId())).thenReturn(Optional.of(mockUserDetails));

		when(ticketRepository.findById(1L)).thenReturn(Optional.of(mockTicket));

		TicketOutDto result = ticketService.updateTicket(ticketUpdateDto, 1L);
		result.setTicketId(1L);

		assertNotNull(result);

		assertEquals(mockTicket.getTicketId(), result.getTicketId());
		assertEquals(mockTicket.getTicketTitle(), result.getTicketTitle());
		assertEquals(mockTicket.getTicketStatus(), result.getTicketStatus());
		verify(commentRepository, times(1)).save(any(Comment.class));
		verify(userRepository, times(1)).findById(ticketUpdateDto.getUserId());
		verify(ticketRepository, times(1)).findById(1L);
	}

	@Test
	public void testGetAllTicketsMapping_Member() {

		UserDetails userDetails = new UserDetails();
		userDetails.setName("Sneha");
		userDetails.setUserId(1);
		userDetails.setDepartment(new Department());
		userDetails.setEmail("sneha@nucleusteq.com");
		userDetails.setIsLoggedIn(true);
		userDetails.setName("Sneha");
		userDetails.setPassword("password");
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setUsertype(UserType.Member);

		Department department = new Department();
		department.setDeptName("IT");
		department.setDeptId(1);
		department.setTickets(new ArrayList<Ticket>());
		department.setUserDetails(new ArrayList<UserDetails>());

		Ticket ticket1 = new Ticket();
		ticket1.setTicketId(1L);
		ticket1.setUserDetails(userDetails);
		ticket1.setDepartment(department);
		ticket1.setTicketTitle("abc");
		ticket1.setTicketType(TicketType.Grievance);
		ticket1.setTicketStatus(TicketStatus.Open);
		ticket1.setUpdatedAt(new Date());
		ticket1.setComments(new ArrayList<Comment>());
		ticket1.setCreatedAt(new Date());
		ticket1.setDescription("abcd");

		Ticket ticket2 = new Ticket();
		ticket2.setTicketId(2L);
		ticket2.setUserDetails(userDetails);
		ticket2.setDepartment(department);
		ticket2.setTicketTitle("abcd");
		ticket2.setTicketType(TicketType.Feedback);
		ticket2.setTicketStatus(TicketStatus.Resolved);
		ticket2.setUpdatedAt(new Date());
		ticket2.setComments(new ArrayList<Comment>());
		ticket2.setCreatedAt(new Date());
		ticket2.setDescription("abcd");

		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket1);
		tickets.add(ticket2);

		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "All";

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Ticket> ticketPage = new PageImpl<>(tickets, pageable, tickets.size());

		when(userRepository.findByEmail("sneha@nucleusteq.com")).thenReturn(userDetails);

		when(ticketRepository.findByUserDetails(userDetails, pageable)).thenReturn(ticketPage);

		List<TicketOutDto> dtos = ticketService.getAllTickets(pageNumber, pageSize, "sneha@nucleusteq.com", type,
				filter);

		assertEquals(2, dtos.size());
		TicketOutDto dto1 = dtos.get(0);
		TicketOutDto dto2 = dtos.get(1);

		assertEquals(ticket1.getTicketId(), dto1.getTicketId());
		assertEquals(ticket1.getUserDetails().getName(), dto1.getName());
		assertEquals(ticket1.getDepartment().getDeptName(), dto1.getDeptName());
		assertEquals(ticket1.getTicketTitle(), dto1.getTicketTitle());
		assertEquals(ticket1.getTicketType(), dto1.getTicketType());
		assertEquals(ticket1.getTicketStatus(), dto1.getTicketStatus());
		assertEquals(ticket1.getUpdatedAt(), dto1.getUpdatedAt());
		assertEquals(ticket1.getComments(), dto1.getComments());

		assertEquals(ticket2.getTicketId(), dto2.getTicketId());
		assertEquals(ticket2.getUserDetails().getName(), dto2.getName());
		assertEquals(ticket2.getDepartment().getDeptName(), dto2.getDeptName());
		assertEquals(ticket2.getTicketTitle(), dto2.getTicketTitle());
		assertEquals(ticket2.getTicketType(), dto2.getTicketType());
		assertEquals(ticket2.getTicketStatus(), dto2.getTicketStatus());
		assertEquals(ticket2.getUpdatedAt(), dto2.getUpdatedAt());
		assertEquals(ticket2.getComments(), dto2.getComments());
	}

	@Test
	public void testGetAllTicketsMapping_Admin() {

		UserDetails userDetails = new UserDetails();
		userDetails.setName("Sneha");
		userDetails.setUserId(1);
		userDetails.setDepartment(new Department());
		userDetails.setEmail("sneha@nucleusteq.com");
		userDetails.setIsLoggedIn(true);
		userDetails.setName("Sneha");
		userDetails.setPassword("password");
		userDetails.setTickets(new ArrayList<Ticket>());
		userDetails.setUsertype(UserType.Admin);

		Department department = new Department();
		department.setDeptName("IT");
		department.setDeptId(1);
		department.setTickets(new ArrayList<Ticket>());
		department.setUserDetails(new ArrayList<UserDetails>());

		Ticket ticket1 = new Ticket();
		ticket1.setTicketId(1L);
		ticket1.setUserDetails(userDetails);
		ticket1.setDepartment(department);
		ticket1.setTicketTitle("abc");
		ticket1.setTicketType(TicketType.Grievance);
		ticket1.setTicketStatus(TicketStatus.Open);
		ticket1.setUpdatedAt(new Date());
		ticket1.setComments(new ArrayList<Comment>());
		ticket1.setCreatedAt(new Date());
		ticket1.setDescription("abcd");

		Ticket ticket2 = new Ticket();
		ticket2.setTicketId(2L);
		ticket2.setUserDetails(userDetails);
		ticket2.setDepartment(department);
		ticket2.setTicketTitle("abcd");
		ticket2.setTicketType(TicketType.Feedback);
		ticket2.setTicketStatus(TicketStatus.Resolved);
		ticket2.setUpdatedAt(new Date());
		ticket2.setComments(new ArrayList<Comment>());
		ticket2.setCreatedAt(new Date());
		ticket2.setDescription("abcd");

		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket1);
		tickets.add(ticket2);

		Integer pageNumber = 0;
		Integer pageSize = 10;
		String type = "My Tickets";
		String filter = "All";

		Sort sort = Sort.by("ticketStatus");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Ticket> ticketPage = new PageImpl<>(tickets, pageable, tickets.size());

		when(userRepository.findByEmail("sneha@nucleusteq.com")).thenReturn(userDetails);

		when(ticketRepository.findByUserDetails(userDetails, pageable)).thenReturn(ticketPage);

		List<TicketOutDto> dtos = ticketService.getAllTickets(pageNumber, pageSize, "sneha@nucleusteq.com", type,
				filter);

		assertEquals(2, dtos.size());
		TicketOutDto dto1 = dtos.get(0);
		TicketOutDto dto2 = dtos.get(1);

		assertEquals(ticket1.getTicketId(), dto1.getTicketId());
		assertEquals(ticket1.getUserDetails().getName(), dto1.getName());
		assertEquals(ticket1.getDepartment().getDeptName(), dto1.getDeptName());
		assertEquals(ticket1.getTicketTitle(), dto1.getTicketTitle());
		assertEquals(ticket1.getTicketType(), dto1.getTicketType());
		assertEquals(ticket1.getTicketStatus(), dto1.getTicketStatus());
		assertEquals(ticket1.getUpdatedAt(), dto1.getUpdatedAt());
		assertEquals(ticket1.getComments(), dto1.getComments());

		assertEquals(ticket2.getTicketId(), dto2.getTicketId());
		assertEquals(ticket2.getUserDetails().getName(), dto2.getName());
		assertEquals(ticket2.getDepartment().getDeptName(), dto2.getDeptName());
		assertEquals(ticket2.getTicketTitle(), dto2.getTicketTitle());
		assertEquals(ticket2.getTicketType(), dto2.getTicketType());
		assertEquals(ticket2.getTicketStatus(), dto2.getTicketStatus());
		assertEquals(ticket2.getUpdatedAt(), dto2.getUpdatedAt());
		assertEquals(ticket2.getComments(), dto2.getComments());
	}
}
