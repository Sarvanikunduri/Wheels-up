// ---- AUTHENTICATION HTML ----
document.getElementById('auth-gate').innerHTML = `
<div class="fixed inset-0 bg-gray-50 z-50 flex items-center justify-center p-4">
  <div class="bg-white rounded-2xl shadow-2xl w-full max-w-lg p-10 md:p-12 text-center border-t-8 border-primary">
    <i data-lucide="key" class="w-12 h-12 text-primary mx-auto mb-4"></i>
    <h1 class="text-3xl font-extrabold text-gray-900 mb-2">Welcome to <span class="text-primary">WheelsUp</span></h1>
    <p class="text-gray-600 mb-8">Please register or sign in to access the rental platform and view vehicles.</p>

    <div id="auth-content">
        <div id="register-form" class="space-y-4">
            <h2 class="text-xl font-bold text-gray-800 border-b pb-2">Register</h2>
            <input type="text" id="reg-name" placeholder="Full Name" class="w-full p-3 border border-gray-300 rounded-lg focus:ring-primary focus:border-primary">
            <input type="email" id="reg-email" placeholder="Email Address" class="w-full p-3 border border-gray-300 rounded-lg focus:ring-primary focus:border-primary">
            <input type="password" id="reg-password" placeholder="Password (min 8 characters)" class="w-full p-3 border border-gray-300 rounded-lg focus:ring-primary focus:border-primary">
            <button onclick="simulateLogin('Jane Doe')" class="w-full bg-primary text-white p-3 rounded-xl font-bold hover-primary transition duration-300 shadow-lg shadow-red-300/60">
                Register and Start Riding
            </button>
            <p class="text-sm text-center text-gray-600">Already have an account? <a href="#" onclick="switchAuthMode('login')" class="text-primary font-medium hover:underline">Login here</a></p>
        </div>
        <div id="login-form" class="space-y-4 hidden">
            <h2 class="text-xl font-bold text-gray-800 border-b pb-2">Login</h2>
            <input type="email" id="login-email" placeholder="Email Address" class="w-full p-3 border border-gray-300 rounded-lg focus:ring-primary focus:border-primary">
            <input type="password" id="login-password" placeholder="Password" class="w-full p-3 border border-gray-300 rounded-lg focus:ring-primary focus:border-primary">
            <button onclick="simulateLogin('John Smith')" class="w-full bg-primary text-white p-3 rounded-xl font-bold hover-primary transition duration-300 shadow-lg shadow-red-300/60">
                Sign In
            </button>
            <p class="text-sm text-center text-gray-600">Don't have an account? <a href="#" onclick="switchAuthMode('register')" class="text-primary font-medium hover:underline">Register now</a></p>
        </div>
    </div>
    <p id="auth-message" class="text-red-500 mt-4 text-sm hidden">Please complete all fields.</p>
  </div>
</div>
`;

// ---- MAIN APP HTML ----
// You can similarly move the entire "main-app-container" innerHTML here (truncated for brevity)
document.getElementById('main-app-container').innerHTML = `
<header><!-- header content --></header>
<main><!-- main content --></main>
<footer><!-- footer content --></footer>
<div id="booking-modal"></div>
`;

// ---- JS LOGIC ----
// Copy all your authentication, vehicle, booking, offer logic here from the original script.js
// (everything inside <script> from your original HTML)
