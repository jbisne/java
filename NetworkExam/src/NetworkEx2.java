import java.net.URL;

class NetworkEx2 {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.enjoypuzzle.com:80/" +
								"board/bbsview/nemonotice/260/1#1");
		
		System.out.println("url.getAuthority():" +url.getAuthority());
		System.out.println("url.getContent():"  +url.getContent());
		System.out.println("url.getDefaultPort():" +url.getDefaultPort());
		System.out.println("url.getPort():" +url.getPort());
		System.out.println("url.getFile():" +url.getFile());
		System.out.println("url.getHost():" +url.getHost());
		System.out.println("url.getPath():" +url.getPath());
		System.out.println("url.getProtocol():" +url.getQuery());
		System.out.println("url.getQuery():" +url.getQuery());
		System.out.println("url.getUserUnfo():" +url.getUserInfo());
		System.out.println("url.toExternalForm():" +url.toExternalForm());
		System.out.println("url.toURI():" +url.toURI());				
	}

}
//http://www.enjoypuzzle.com/board/bbsview/nemonotice/260/1#1 링크 주소