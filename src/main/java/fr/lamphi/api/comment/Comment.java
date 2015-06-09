package fr.lamphi.api.comment;


public class Comment {
	private int idUser;
	private String date;
	private String contenu;
	private int id;
	private int idLesson;
	
	public Comment(){}
	
	public Comment(int id, int idUser, int idLesson, String contenu, String date ){
		this.setIdUser(idUser);
		this.setDate(date);
		this.setContenu(contenu);
		this.setId(id);
		this.setIdLesson(idLesson);
	}


	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdLesson() {
		return idLesson;
	}

	public void setIdLesson(int idLesson) {
		this.idLesson = idLesson;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	String contenu = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in rhoncus ante. In auctor magna rutrum, vehicula mauris ac, cursus velit. Cras porta lacinia justo, euismod consectetur odio viverra laoreet. Donec erat dolor, varius ut ipsum nec, vestibulum cursus nunc. Fusce non scelerisque nibh. Integer a bibendum ipsum. Mauris vehicula felis et nibh scelerisque, blandit suscipit lacus rhoncus. In fermentum tortor elit, sit amet vestibulum urna ultrices at. Nullam in risus tincidunt sem blandit malesuada. Maecenas mattis vitae urna id venenatis. Aliquam tempor, dolor id aliquam tincidunt, sem ligula suscipit velit, nec suscipit nulla nunc sagittis ligula. Sed et dictum nibh, vel rhoncus leo. Praesent lobortis quam in lacus tincidunt, vitae consequat mauris faucibus. Pellentesque vitae dictum sem.		</p>		<p>		Sed sit amet suscipit massa. Donec non justo ultrices, gravida mi facilisis, feugiat diam. Fusce quis nulla vel metus rutrum vulputate. Cras aliquam feugiat nibh vitae aliquet. Sed suscipit ligula tincidunt interdum bibendum. Aenean lectus tortor, maximus vitae dui ut, volutpat porta velit. Morbi nec dapibus massa, ultrices vehicula lorem. Nam efficitur feugiat metus, sed tristique dolor eleifend at. In at lorem ut neque consectetur fermentum. Cras eleifend lorem eu justo tincidunt, ac tempus nisi mattis. Ut nec felis ac lorem vestibulum consectetur.		</p>		<p>		Mauris pellentesque est massa, non cursus purus ultrices nec. Etiam finibus, lectus ut aliquam malesuada, magna lacus viverra velit, sit amet suscipit nunc dui eget purus. Nullam molestie nisl diam, vel cursus dolor tincidunt a. Nulla sit amet finibus nibh, id eleifend nisi. Phasellus nec urna ex. Fusce ac suscipit sapien. Suspendisse potenti. In hac habitasse platea dictumst.		</p>		<p>		Praesent et ultricies magna. Etiam erat tortor, consectetur ut ex sit amet, tincidunt laoreet dolor. Integer eu tincidunt velit. Nam tincidunt eros nec tellus interdum tincidunt. Aliquam erat volutpat. In in orci interdum, pellentesque nibh eget, cursus enim. Nam orci risus, laoreet sed nulla sit amet, placerat finibus dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse porta bibendum scelerisque. In eget nulla hendrerit, fermentum risus quis, consequat enim. Donec quis aliquam risus. Nullam at condimentum erat, eget pellentesque lorem.		</p>		<p>		In commodo odio a risus mollis, ac sagittis velit dignissim. Suspendisse potenti. Curabitur orci sapien, aliquet vitae sem finibus, ornare faucibus enim. Donec porta interdum libero, ut varius purus eleifend a. Suspendisse ornare elementum nunc id placerat. Praesent congue finibus tristique. Mauris vestibulum urna tellus, eu tempor sapien vehicula et. Vestibulum egestas dolor a lorem efficitur dictum. Vestibulum euismod leo in nisl convallis, non ultricies est ornare. Aenean id tincidunt elit. Ut imperdiet dictum risus hendrerit mollis. Morbi varius est nibh, a sodales nisl elementum eu.</p>";

	String contenu = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in rhoncus ante. In auctor magna rutrum, vehicula mauris ac, cursus velit. Cras porta lacinia justo, euismod consectetur odio viverra laoreet. Donec erat dolor, varius ut ipsum nec, vestibulum cursus nunc. Fusce non scelerisque nibh. Integer a bibendum ipsum. Mauris vehicula felis et nibh scelerisque, blandit suscipit lacus rhoncus. In fermentum tortor elit, sit amet vestibulum urna ultrices at. Nullam in risus tincidunt sem blandit malesuada. Maecenas mattis vitae urna id venenatis. Aliquam tempor, dolor id aliquam tincidunt, sem ligula suscipit velit, nec suscipit nulla nunc sagittis ligula. Sed et dictum nibh, vel rhoncus leo. Praesent lobortis quam in lacus tincidunt, vitae consequat mauris faucibus. Pellentesque vitae dictum sem.		</p>		<p>		Sed sit amet suscipit massa. Donec non justo ultrices, gravida mi facilisis, feugiat diam. Fusce quis nulla vel metus rutrum vulputate. Cras aliquam feugiat nibh vitae aliquet. Sed suscipit ligula tincidunt interdum bibendum. Aenean lectus tortor, maximus vitae dui ut, volutpat porta velit. Morbi nec dapibus massa, ultrices vehicula lorem. Nam efficitur feugiat metus, sed tristique dolor eleifend at. In at lorem ut neque consectetur fermentum. Cras eleifend lorem eu justo tincidunt, ac tempus nisi mattis. Ut nec felis ac lorem vestibulum consectetur.		</p>		<p>		Mauris pellentesque est massa, non cursus purus ultrices nec. Etiam finibus, lectus ut aliquam malesuada, magna lacus viverra velit, sit amet suscipit nunc dui eget purus. Nullam molestie nisl diam, vel cursus dolor tincidunt a. Nulla sit amet finibus nibh, id eleifend nisi. Phasellus nec urna ex. Fusce ac suscipit sapien. Suspendisse potenti. In hac habitasse platea dictumst.		</p>		<p>		Praesent et ultricies magna. Etiam erat tortor, consectetur ut ex sit amet, tincidunt laoreet dolor. Integer eu tincidunt velit. Nam tincidunt eros nec tellus interdum tincidunt. Aliquam erat volutpat. In in orci interdum, pellentesque nibh eget, cursus enim. Nam orci risus, laoreet sed nulla sit amet, placerat finibus dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse porta bibendum scelerisque. In eget nulla hendrerit, fermentum risus quis, consequat enim. Donec quis aliquam risus. Nullam at condimentum erat, eget pellentesque lorem.		</p>		<p>		In commodo odio a risus mollis, ac sagittis velit dignissim. Suspendisse potenti. Curabitur orci sapien, aliquet vitae sem finibus, ornare faucibus enim. Donec porta interdum libero, ut varius purus eleifend a. Suspendisse ornare elementum nunc id placerat. Praesent congue finibus tristique. Mauris vestibulum urna tellus, eu tempor sapien vehicula et. Vestibulum egestas dolor a lorem efficitur dictum. Vestibulum euismod leo in nisl convallis, non ultricies est ornare. Aenean id tincidunt elit. Ut imperdiet dictum risus hendrerit mollis. Morbi varius est nibh, a sodales nisl elementum eu.</p>";

	String contenu = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in rhoncus ante. In auctor magna rutrum, vehicula mauris ac, cursus velit. Cras porta lacinia justo, euismod consectetur odio viverra laoreet. Donec erat dolor, varius ut ipsum nec, vestibulum cursus nunc. Fusce non scelerisque nibh. Integer a bibendum ipsum. Mauris vehicula felis et nibh scelerisque, blandit suscipit lacus rhoncus. In fermentum tortor elit, sit amet vestibulum urna ultrices at. Nullam in risus tincidunt sem blandit malesuada. Maecenas mattis vitae urna id venenatis. Aliquam tempor, dolor id aliquam tincidunt, sem ligula suscipit velit, nec suscipit nulla nunc sagittis ligula. Sed et dictum nibh, vel rhoncus leo. Praesent lobortis quam in lacus tincidunt, vitae consequat mauris faucibus. Pellentesque vitae dictum sem.		</p>		<p>		Sed sit amet suscipit massa. Donec non justo ultrices, gravida mi facilisis, feugiat diam. Fusce quis nulla vel metus rutrum vulputate. Cras aliquam feugiat nibh vitae aliquet. Sed suscipit ligula tincidunt interdum bibendum. Aenean lectus tortor, maximus vitae dui ut, volutpat porta velit. Morbi nec dapibus massa, ultrices vehicula lorem. Nam efficitur feugiat metus, sed tristique dolor eleifend at. In at lorem ut neque consectetur fermentum. Cras eleifend lorem eu justo tincidunt, ac tempus nisi mattis. Ut nec felis ac lorem vestibulum consectetur.		</p>		<p>		Mauris pellentesque est massa, non cursus purus ultrices nec. Etiam finibus, lectus ut aliquam malesuada, magna lacus viverra velit, sit amet suscipit nunc dui eget purus. Nullam molestie nisl diam, vel cursus dolor tincidunt a. Nulla sit amet finibus nibh, id eleifend nisi. Phasellus nec urna ex. Fusce ac suscipit sapien. Suspendisse potenti. In hac habitasse platea dictumst.		</p>		<p>		Praesent et ultricies magna. Etiam erat tortor, consectetur ut ex sit amet, tincidunt laoreet dolor. Integer eu tincidunt velit. Nam tincidunt eros nec tellus interdum tincidunt. Aliquam erat volutpat. In in orci interdum, pellentesque nibh eget, cursus enim. Nam orci risus, laoreet sed nulla sit amet, placerat finibus dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse porta bibendum scelerisque. In eget nulla hendrerit, fermentum risus quis, consequat enim. Donec quis aliquam risus. Nullam at condimentum erat, eget pellentesque lorem.		</p>		<p>		In commodo odio a risus mollis, ac sagittis velit dignissim. Suspendisse potenti. Curabitur orci sapien, aliquet vitae sem finibus, ornare faucibus enim. Donec porta interdum libero, ut varius purus eleifend a. Suspendisse ornare elementum nunc id placerat. Praesent congue finibus tristique. Mauris vestibulum urna tellus, eu tempor sapien vehicula et. Vestibulum egestas dolor a lorem efficitur dictum. Vestibulum euismod leo in nisl convallis, non ultricies est ornare. Aenean id tincidunt elit. Ut imperdiet dictum risus hendrerit mollis. Morbi varius est nibh, a sodales nisl elementum eu.</p>";
	
	
	
}
