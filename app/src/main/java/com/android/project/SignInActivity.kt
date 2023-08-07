package com.android.project


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    lateinit var signInLauncher: ActivityResultLauncher<Intent>
     var intent1_1_id: String? = null
     var intent2_1_psw: String? = null
     var intent3_1_name: String? = null
     var intent4_1_age: String? = null
     var intent5_1_mbti: String? = null
    //변수를 선언해주는 이유는 아래 registerForActivityResult를 이용해서 SignUpActivity에서 입력한 회원가입정보를 가져오는데 그 데이터를 이 변수들에 담아주기 위해서이다.
    //클래스 변수로 선언해준 이유는 SignInActivity 모든 메소드에서 사용하기위해서이다.
//변수에 초기값을 지정해야되는데 null값도 가지겠다는 말이다. 그리고 초기값을 null로 설정해주면 null이 할당되더라도 안정성을 높일 수 있다.

   companion object{ var idList = mutableListOf<String>()}
    //얘만 companion object로 지정해준 이유는 SignInActivity에서 id를 idList에 누적해서 저장하는데 그걸 SignUpActivity에서 다시 idList를 부를때 데이터가 초기화되기때문이다.
    //그렇지 않으면  SignUpActivity에서 이곳 idList를 다시 가져가서 id중복체크를 해야되는데 인스턴스가 초기화되서 idList에 id값이 누적되지 않는다. Kiosk과제할때 메뉴들이 장바구니에 누적시키는거랑 같은 개념
    var pswList = mutableListOf<String>()
    var nameList = mutableListOf<String>()
    var ageList = mutableListOf<String>()
    var mbtiList = mutableListOf<String>()
    //각각을 mutableListOf<String>로 지정해준 이유는 SignUpActivity에서 회원가입을 할때마다 데이터를 각각의 List에 넣어주기 위해서이다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val edit_id = findViewById<EditText>(R.id.editTextId1_1)
        val edit_psw = findViewById<EditText>(R.id.editTextPassword2_1)
        val btn_calllognin1_1 = findViewById<Button>(R.id.btnlogin1_1)
        //각 변수들에 xml에서 작성한 위젯들을 불러오고
        btn_calllognin1_1.setOnClickListener {
            val id = edit_id.text.toString()
            val psw = edit_psw.text.toString()
            //위에서 불러온 위젯의 text에 입력값을 담아서 id,psw에 넣어준다.( 여기서 위젯.text를 안붙여주면 입력하는 칸(text)에 입력하는게아니라 그냥 위젯에다가 말거는거다.)
            if (!id.isEmpty() && !psw.isEmpty()) {
                    val index = idList.indexOf(id)
                //idList에 있는 id의 인덱스번째가 index변수에 들어간다.
                //이건 예를들어보자 idList = (a,b,c,d) 라는 id들이 들어있다고 한다면(회원가입할떄 a,b,c,d라는 id들로 가입했을때)
                // 만약 내가 로그인하려고 id입력칸에 d를 입력했다면 idList.indexOf(id=c 대입) 이되어서 idList의 c가있는 인덱스가 index변수에 들어가게된다.
                //요약해서 idList에서 내가 로그인하려는 id의 인덱스를 index변수에 넣어주는것이다.
                if (index >=0 && id == idList[index] && psw == pswList[index]) {
                    //null값일때(-1)는 else로 빠지기전에 java.lang.ArrayIndexOutOfBoundsException 에러가 생기기때문에 index>=0 조건을 추가한다.
                    //또한 index >=0 얘를 가장 먼저 써줘야된다. id == idList[index] && psw == pswList[index] &&index >=0  이렇게 써주면
                    //처음 조건볼때 이미 index가 null값이라면 id =idList[없는값]이 되어버려서 애러가나기때문에 먼저 null값이 아닌걸 말해줘야한다. 순서가 매우 중요함.
                    spf.saveData(this,"dataFromSignInActivityId", idList[index])
                    spf.saveData(this,"dataFromSignInActivityName", nameList[index])
                    spf.saveData(this,"dataFromSignInActivityAge", ageList[index])
                    spf.saveData(this,"dataFromSignInActivityMbti", mbtiList[index])
                    //얘들은 sharedPreferences를 이용해서 object spf라는곳에 회원가입한 데이터들(mutableListOf형태로 누적됨)을 저장하기 위해서인데
                    //각각 List전체를 넘겨준게아니라 List의 index번째를 넘겨준이유는 로그인 한다면 HomeActivity에서 저장된 회원정보중에서
                    //현재 로그인한 id와 관련된 정보만 출력하기 때문에 로그인할때 id의 index를 이용해서 각각List의 index번째 데이터만 sharedPreferences에 저장했다.
                    val intent1 = Intent(this, HomeActivity::class.java) // SignInActivity에서 HomeActivity로 넘어가는 통로라고 생각하면 될꺼같다.
                    startActivity(intent1)//통로를이용해서 페이지 전환
                    Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        val btn_calljoin2_1 = findViewById<Button>(R.id.btnjoin2_1)
        btn_calljoin2_1.setOnClickListener {
            val intent2_1 = Intent(this, SignUpActivity::class.java)    //이것역시  SignUpActivity로 넘어가는 통로
            signInLauncher.launch(intent2_1)    //startActivity와 비슷하게 통로를 이용해서 해당 Activity로 넘어가는건 동일한 기능인데
            //startActivity는 회원가입했을때 입력한 데이터를 못받아오고 signInLauncher.launch는 받아온다.
            //요약해서 startActivity는 단순이 다른Activity로 페이지만 이동하는것이다.
        }
        signInLauncher =    // lateinit로 선언한 signInLauncher 변수를 여기서 초기화 시켜준다. lateinit으로 선언해준 이유이다.
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result -> //이건 데이터를 가져오려면 그냥 외우자 정해진것이다.
                if (result.resultCode == RESULT_OK) {   // 회원가입페이지에서 회원가입을 성공적으로 마치고 넘어왔을때라는 뜻이다.
                    val data = result.data      //result.data에 회원가입할때 입력한 모든정보가 intent로 저장되어있다. 그걸 data라는 변수에 담아준다.
                    if (data != null) {             //data에 담긴 회원가입때 입력한 정보들이 null값이 아니라면 실행
                        intent1_1_id = data.getStringExtra("dataFromSignUpActivityId")
                        intent2_1_psw = data.getStringExtra("dataFromSignUpActivityPsw")
                        intent3_1_name = data.getStringExtra("dataFromSignUpActivityName")
                        intent4_1_age = data.getStringExtra("dataFromSignUpActivityAge")
                        intent5_1_mbti = data.getStringExtra("dataFromSignUpActivity")
                        // SignUpActivity에서 입력한 값들을 intent로 넘겨줐고 그걸 result.data로받아서 data변수에 담아줬기때문에
                        //data에있는 데이터들을 getStringExtra(얻어오는것) 인데 data안에 들어있는 정보들의 각각의 이름들을 이용해서(SignUpActivity에서 저장할때 저장공간이름)
                        //맨위에서 선언해준 변수들에 각각 담아준다.
                        //맨위에서 이변수들을 선언해준 이유이다. 맨위에서(클래스변수로) 변수들을 선언해주지않았다면
                        //이 변수들을 SignInActivity클래스에서 사용할 수없다. signInLauncher 내부에서만 사용가능하다.
                        idList.add(intent1_1_id ?: "")
                        pswList.add(intent2_1_psw ?: "")
                        nameList.add(intent3_1_name ?: "")
                        ageList.add(intent4_1_age ?: "")
                        mbtiList.add(intent5_1_mbti ?: "")
                        //각각의 List에 회원가입할때 입력한 데이터들을 추가해준다. 왜냐하면 회원가입을 1번만 할께 아니기때문에
                        //뒤에 ?: "" 이건 회원가입할때 모든정보를 입력하지않으면 null값이 발생할 수 있기때문에 엘비스 연산자를 이용해 null값일때 빈칸으로 두었다.
                        //하지만 회원가입할때 모든정보를 입력해야 회원가입을 하게 해놔서 구지 안써도될것같긴한데 혹시모르니 썻다.
                        edit_id.setText(intent1_1_id)
                        edit_psw.setText(intent2_1_psw)
                        //얘들은 Lv4.회원 가입페이지에서 입력한 아이디/비밀번호가 로그인 화면으로 돌아올 때 자동 입력되는 기능이다.
                    }
                }
            }
    }


}

