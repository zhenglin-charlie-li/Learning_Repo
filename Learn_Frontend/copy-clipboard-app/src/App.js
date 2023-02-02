import { CopyToClipboard } from 'react-copy-to-clipboard';

export default function App() {
  return (
    <div className="App">
      <h1>Clipboard Copy</h1>
      <CopyToClipboard text="textsssss" onCopy={() => alert('Copied')}>
        <span>Copy to clipboard with span</span>
      </CopyToClipboard>
    </div>
  );
}
