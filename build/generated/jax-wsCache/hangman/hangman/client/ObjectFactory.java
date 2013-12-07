
package hangman.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hangman.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateGameResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "createGameResponse");
    private final static QName _GetGameById_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getGameById");
    private final static QName _GetPlayersAssignedToGame_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getPlayersAssignedToGame");
    private final static QName _GetPlayerByIdResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getPlayerByIdResponse");
    private final static QName _GetGameListResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getGameListResponse");
    private final static QName _GetPlayerById_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getPlayerById");
    private final static QName _CheckLetterResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "checkLetterResponse");
    private final static QName _GetPlayerListResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getPlayerListResponse");
    private final static QName _AddPlayerToGame_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "addPlayerToGame");
    private final static QName _CreatePlayerResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "createPlayerResponse");
    private final static QName _CheckLetter_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "checkLetter");
    private final static QName _CreatePlayer_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "createPlayer");
    private final static QName _GetPlayerList_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getPlayerList");
    private final static QName _GetGameByIdResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getGameByIdResponse");
    private final static QName _AddPlayerToGameResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "addPlayerToGameResponse");
    private final static QName _GetGameList_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getGameList");
    private final static QName _CreateGame_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "createGame");
    private final static QName _GetPlayersAssignedToGameResponse_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "getPlayersAssignedToGameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hangman.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GameResult }
     * 
     */
    public GameResult createGameResult() {
        return new GameResult();
    }

    /**
     * Create an instance of {@link GameResult.PlayerCountOfFailure }
     * 
     */
    public GameResult.PlayerCountOfFailure createGameResultPlayerCountOfFailure() {
        return new GameResult.PlayerCountOfFailure();
    }

    /**
     * Create an instance of {@link GameResult.PlayerCountOfAttempt }
     * 
     */
    public GameResult.PlayerCountOfAttempt createGameResultPlayerCountOfAttempt() {
        return new GameResult.PlayerCountOfAttempt();
    }

    /**
     * Create an instance of {@link GetGameListResponse }
     * 
     */
    public GetGameListResponse createGetGameListResponse() {
        return new GetGameListResponse();
    }

    /**
     * Create an instance of {@link GetPlayerById }
     * 
     */
    public GetPlayerById createGetPlayerById() {
        return new GetPlayerById();
    }

    /**
     * Create an instance of {@link GetPlayerListResponse }
     * 
     */
    public GetPlayerListResponse createGetPlayerListResponse() {
        return new GetPlayerListResponse();
    }

    /**
     * Create an instance of {@link CheckLetterResponse }
     * 
     */
    public CheckLetterResponse createCheckLetterResponse() {
        return new CheckLetterResponse();
    }

    /**
     * Create an instance of {@link CreateGameResponse }
     * 
     */
    public CreateGameResponse createCreateGameResponse() {
        return new CreateGameResponse();
    }

    /**
     * Create an instance of {@link GetPlayersAssignedToGame }
     * 
     */
    public GetPlayersAssignedToGame createGetPlayersAssignedToGame() {
        return new GetPlayersAssignedToGame();
    }

    /**
     * Create an instance of {@link GetPlayerByIdResponse }
     * 
     */
    public GetPlayerByIdResponse createGetPlayerByIdResponse() {
        return new GetPlayerByIdResponse();
    }

    /**
     * Create an instance of {@link GetGameById }
     * 
     */
    public GetGameById createGetGameById() {
        return new GetGameById();
    }

    /**
     * Create an instance of {@link AddPlayerToGameResponse }
     * 
     */
    public AddPlayerToGameResponse createAddPlayerToGameResponse() {
        return new AddPlayerToGameResponse();
    }

    /**
     * Create an instance of {@link GetGameList }
     * 
     */
    public GetGameList createGetGameList() {
        return new GetGameList();
    }

    /**
     * Create an instance of {@link GetPlayerList }
     * 
     */
    public GetPlayerList createGetPlayerList() {
        return new GetPlayerList();
    }

    /**
     * Create an instance of {@link GetGameByIdResponse }
     * 
     */
    public GetGameByIdResponse createGetGameByIdResponse() {
        return new GetGameByIdResponse();
    }

    /**
     * Create an instance of {@link GetPlayersAssignedToGameResponse }
     * 
     */
    public GetPlayersAssignedToGameResponse createGetPlayersAssignedToGameResponse() {
        return new GetPlayersAssignedToGameResponse();
    }

    /**
     * Create an instance of {@link CreateGame }
     * 
     */
    public CreateGame createCreateGame() {
        return new CreateGame();
    }

    /**
     * Create an instance of {@link AddPlayerToGame }
     * 
     */
    public AddPlayerToGame createAddPlayerToGame() {
        return new AddPlayerToGame();
    }

    /**
     * Create an instance of {@link CheckLetter }
     * 
     */
    public CheckLetter createCheckLetter() {
        return new CheckLetter();
    }

    /**
     * Create an instance of {@link CreatePlayer }
     * 
     */
    public CreatePlayer createCreatePlayer() {
        return new CreatePlayer();
    }

    /**
     * Create an instance of {@link CreatePlayerResponse }
     * 
     */
    public CreatePlayerResponse createCreatePlayerResponse() {
        return new CreatePlayerResponse();
    }

    /**
     * Create an instance of {@link Player }
     * 
     */
    public Player createPlayer() {
        return new Player();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link GameResult.PlayerCountOfFailure.Entry }
     * 
     */
    public GameResult.PlayerCountOfFailure.Entry createGameResultPlayerCountOfFailureEntry() {
        return new GameResult.PlayerCountOfFailure.Entry();
    }

    /**
     * Create an instance of {@link GameResult.PlayerCountOfAttempt.Entry }
     * 
     */
    public GameResult.PlayerCountOfAttempt.Entry createGameResultPlayerCountOfAttemptEntry() {
        return new GameResult.PlayerCountOfAttempt.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "createGameResponse")
    public JAXBElement<CreateGameResponse> createCreateGameResponse(CreateGameResponse value) {
        return new JAXBElement<CreateGameResponse>(_CreateGameResponse_QNAME, CreateGameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getGameById")
    public JAXBElement<GetGameById> createGetGameById(GetGameById value) {
        return new JAXBElement<GetGameById>(_GetGameById_QNAME, GetGameById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlayersAssignedToGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getPlayersAssignedToGame")
    public JAXBElement<GetPlayersAssignedToGame> createGetPlayersAssignedToGame(GetPlayersAssignedToGame value) {
        return new JAXBElement<GetPlayersAssignedToGame>(_GetPlayersAssignedToGame_QNAME, GetPlayersAssignedToGame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlayerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getPlayerByIdResponse")
    public JAXBElement<GetPlayerByIdResponse> createGetPlayerByIdResponse(GetPlayerByIdResponse value) {
        return new JAXBElement<GetPlayerByIdResponse>(_GetPlayerByIdResponse_QNAME, GetPlayerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getGameListResponse")
    public JAXBElement<GetGameListResponse> createGetGameListResponse(GetGameListResponse value) {
        return new JAXBElement<GetGameListResponse>(_GetGameListResponse_QNAME, GetGameListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlayerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getPlayerById")
    public JAXBElement<GetPlayerById> createGetPlayerById(GetPlayerById value) {
        return new JAXBElement<GetPlayerById>(_GetPlayerById_QNAME, GetPlayerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLetterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "checkLetterResponse")
    public JAXBElement<CheckLetterResponse> createCheckLetterResponse(CheckLetterResponse value) {
        return new JAXBElement<CheckLetterResponse>(_CheckLetterResponse_QNAME, CheckLetterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlayerListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getPlayerListResponse")
    public JAXBElement<GetPlayerListResponse> createGetPlayerListResponse(GetPlayerListResponse value) {
        return new JAXBElement<GetPlayerListResponse>(_GetPlayerListResponse_QNAME, GetPlayerListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPlayerToGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "addPlayerToGame")
    public JAXBElement<AddPlayerToGame> createAddPlayerToGame(AddPlayerToGame value) {
        return new JAXBElement<AddPlayerToGame>(_AddPlayerToGame_QNAME, AddPlayerToGame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePlayerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "createPlayerResponse")
    public JAXBElement<CreatePlayerResponse> createCreatePlayerResponse(CreatePlayerResponse value) {
        return new JAXBElement<CreatePlayerResponse>(_CreatePlayerResponse_QNAME, CreatePlayerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLetter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "checkLetter")
    public JAXBElement<CheckLetter> createCheckLetter(CheckLetter value) {
        return new JAXBElement<CheckLetter>(_CheckLetter_QNAME, CheckLetter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePlayer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "createPlayer")
    public JAXBElement<CreatePlayer> createCreatePlayer(CreatePlayer value) {
        return new JAXBElement<CreatePlayer>(_CreatePlayer_QNAME, CreatePlayer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlayerList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getPlayerList")
    public JAXBElement<GetPlayerList> createGetPlayerList(GetPlayerList value) {
        return new JAXBElement<GetPlayerList>(_GetPlayerList_QNAME, GetPlayerList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getGameByIdResponse")
    public JAXBElement<GetGameByIdResponse> createGetGameByIdResponse(GetGameByIdResponse value) {
        return new JAXBElement<GetGameByIdResponse>(_GetGameByIdResponse_QNAME, GetGameByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPlayerToGameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "addPlayerToGameResponse")
    public JAXBElement<AddPlayerToGameResponse> createAddPlayerToGameResponse(AddPlayerToGameResponse value) {
        return new JAXBElement<AddPlayerToGameResponse>(_AddPlayerToGameResponse_QNAME, AddPlayerToGameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getGameList")
    public JAXBElement<GetGameList> createGetGameList(GetGameList value) {
        return new JAXBElement<GetGameList>(_GetGameList_QNAME, GetGameList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "createGame")
    public JAXBElement<CreateGame> createCreateGame(CreateGame value) {
        return new JAXBElement<CreateGame>(_CreateGame_QNAME, CreateGame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlayersAssignedToGameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.hangman.wi.msarelo.pl.com/", name = "getPlayersAssignedToGameResponse")
    public JAXBElement<GetPlayersAssignedToGameResponse> createGetPlayersAssignedToGameResponse(GetPlayersAssignedToGameResponse value) {
        return new JAXBElement<GetPlayersAssignedToGameResponse>(_GetPlayersAssignedToGameResponse_QNAME, GetPlayersAssignedToGameResponse.class, null, value);
    }

}
