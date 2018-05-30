package com.example.ronaldbenjamin.saarthironald;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronaldbenjamin.saarthironald.apicalls.PostObject;
import com.example.ronaldbenjamin.saarthironald.apicalls.SaarthiAPI;
import com.example.ronaldbenjamin.saarthironald.models.Cards;
import com.example.ronaldbenjamin.saarthironald.models.ChatResonse;
import com.example.ronaldbenjamin.saarthironald.models.Currently;
import com.example.ronaldbenjamin.saarthironald.models.Message;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;


public class ChatPage extends Fragment {
    private ImageView btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private static final String TAG = "ChatActivity";
    private String UsersentMessage;
    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private TextView buttonSend;
    private int side = 1;
    private Call<ChatResonse> postService;
    private PostObject postObject;
    private TextToSpeech tts;
    private SpeechRecognizer mSpeechRecognizer;
    private Intent mSpeechRecognizerIntent;
    private boolean isListening=false;

    public ChatPage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_page, container, false);
        btnSpeak = view.findViewById(R.id.btnSpeak);
        buttonSend = view.findViewById(R.id.send);
        listView = view.findViewById(R.id.msgview);

        chatArrayAdapter = new ChatArrayAdapter(getContext(), R.layout.right);
        listView.setAdapter(chatArrayAdapter);
        chatText = (EditText) view.findViewById(R.id.msg);
        initSpeech();
        tts = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });

        chatText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    closeKeyboard();
                    return sendChatMessage();
                }
                return false;
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                closeKeyboard();
                sendChatMessage();
                getData();

            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!isListening) {
                    isListening=true;
                    mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                }
            }
        });



        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatArrayAdapter);

        //to scroll the list view to bottom on data change
        chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatArrayAdapter.getCount() - 1);
            }
        });

        return view;
    }

    private void initSpeech() {
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                getActivity().getPackageName());


        SpeechRecognitionListener listener = new SpeechRecognitionListener();
        mSpeechRecognizer.setRecognitionListener(listener);
    }

    private boolean sendChatMessage() {
        buttonSend.setEnabled(false);
        UsersentMessage = chatText.getText().toString();
        chatArrayAdapter.add(new ChatMessage(side, chatText.getText().toString(), null, null));
        chatText.setText("");
        if (side == 1) {
            side = 0;
        } else {
            side = 1;
        }
        return true;
    }

    private boolean sendMessageHistory() {
        chatArrayAdapter.add(new ChatMessage(1, chatText.getText().toString(), null, null));
        chatText.setText("");
        side = 0;
        return true;
    }
    private boolean sendYoutubeCard(Message message)
    {
        chatArrayAdapter.add(new ChatMessage(1, null, "Youtube-Search", message));
        chatText.setText("");
        side = 1;
        return true;
    }

    private boolean sendWeatherCard(Message message) {
        chatArrayAdapter.add(new ChatMessage(1, null, "Weather", message));
        chatText.setText("");
        side = 1;
        return true;
    }

    private boolean sendNewsCard(Message message) {
        chatArrayAdapter.add(new ChatMessage(1, null, "News Headlines", message));
        chatText.setText("");
        side = 1;
        return true;
    }
    private boolean sendBluetoothCard(Message message)
    {
        chatArrayAdapter.add(new ChatMessage(1, null, "Open_bluetooth", message));
        chatText.setText("");
        side = 1;
        return true;
    }
    private boolean sendYoutubePlay(Message message)
    {
        chatArrayAdapter.add(new ChatMessage(1, null, "Youtube-Play", message));
        chatText.setText("");
        side = 1;
        return true;
    }
    private boolean sendFrontCamera(Message message)
    {
        chatArrayAdapter.add(new ChatMessage(1, null, "Open back camera", message));
        chatText.setText("");
        side = 1;
        return true;
    }
    private boolean sendbackCamera(Message message)
    {
        chatArrayAdapter.add(new ChatMessage(1, null, "Open back camera", message));
        chatText.setText("");
        side = 1;
        return true;
    }



    public void getData() {
        String message = UsersentMessage;
        postObject = new PostObject();
        postObject.setMsg(message);
        postObject.setUser_id("15739033-48f8-4cee-aba4-575d457a0a26");
        postService = SaarthiAPI.getService().getChatResponse(postObject);
        postService.enqueue(new Callback<ChatResonse>() {
            @Override
            public void onResponse(Call<ChatResonse> call, Response<ChatResonse> response) {
                ChatResonse chatResonse = response.body();
                Message message1 = chatResonse.getMessage();
                String context = message1.getContext();
                if (message1.getError() == null) {
                    if (message1.getCards() != null) {
                        Cards c[];
                        c = message1.getCards();
                        Log.i("Context", context);
                        if (context.equals("Weather")) {
                            Currently currently = c[0].getCurrently();
                            Log.i("curently", currently.toString());
                            tts.speak("WeatherUpdates", TextToSpeech.QUEUE_FLUSH, null);
                            sendWeatherCard(message1);
                            buttonSend.setEnabled(true);
                        }
                        else if(context.equals("Youtube-Search"))
                        {
                            sendYoutubeCard(message1);
                            buttonSend.setEnabled(true);
                        }
                        else if(context.equals("Youtube-Play"))
                        {
                            sendYoutubePlay(message1);
                            buttonSend.setEnabled(true);
                        }

                        else {

                            sendNewsCard(message1);
                            buttonSend.setEnabled(true);
                        }
                        } else {
                           if(context.equals("Open_bluetooth"))
                              {
                            sendBluetoothCard(message1);
                            buttonSend.setEnabled(true);
                              }
                        else if (context.equals("Open back camera")) {
                            sendFrontCamera(message1);
                            buttonSend.setEnabled(true);
                            Log.i("Open camera","open camera");
                        }
                       /* else
                        if (context.equals("Open back camera")||context.equals("open back camera")) {
                            ((ChatMainPage)getActivity()).initCamera(false,false);

                        }*/
                        else
                        if (context.equals("Selfie")) {
                            sendbackCamera(message1);
                            buttonSend.setEnabled(true);
                            Log.i("Open camera","open camera");
                            ((ChatMainPage)getActivity()).initCamera(true,true);

                        }

                        else {
                            String reply = message1.getText();
                            Log.i("Reply", reply);
                            chatText.setText(reply);
                            sendChatMessage();
                            tts.speak(reply, TextToSpeech.QUEUE_FLUSH, null);
                            buttonSend.setEnabled(true);
                        }
                    }


                } else {

                    String reply = message1.getError();
                    Log.i("Reply", reply);
                    chatText.setText(reply);
                    sendChatMessage();
                    buttonSend.setEnabled(true);
                }

            }

            @Override
            public void onFailure(Call<ChatResonse> call, Throwable t) {
                chatText.setText("Error");
                sendChatMessage();
                buttonSend.setEnabled(true);
                Log.i("Info", "error");
            }
        });


    }

    private void promptSpeechInput(View v) {
        /*Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);

        } catch (ActivityNotFoundException a) {
            Toast.makeText(getContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }*/


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    chatText.setText(result.get(0));
                    sendChatMessage();
                    getData();
                }
                break;
            }

        }


    }

    protected class SpeechRecognitionListener implements RecognitionListener
    {

        @Override
        public void onBeginningOfSpeech()
        {
            //Log.d(TAG, "onBeginingOfSpeech");
        }

        @Override
        public void onBufferReceived(byte[] buffer)
        {

        }

        @Override
        public void onEndOfSpeech()
        {
            //Log.d(TAG, "onEndOfSpeech");
        }

        @Override
        public void onError(int error)
        {
            mSpeechRecognizer.startListening(mSpeechRecognizerIntent);

            //Log.d(TAG, "error = " + error);
        }

        @Override
        public void onEvent(int eventType, Bundle params)
        {

        }

        @Override
        public void onPartialResults(Bundle partialResults)
        {

        }

        @Override
        public void onReadyForSpeech(Bundle params)
        {
            Log.d(TAG, "onReadyForSpeech"); //$NON-NLS-1$
        }

        @Override
        public void onResults(Bundle results)
        {
            //Log.d(TAG, "onResults"); //$NON-NLS-1$
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            isListening=!isListening;
            chatText.setText(matches.get(0));

            // matches are the return values of speech recognition engine
            // Use these values for whatever you wish to do
        }

        @Override
        public void onRmsChanged(float rmsdB)
        {
        }
    }

    public void closeKeyboard(){
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
